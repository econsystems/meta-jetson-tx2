SUMMARY = "Shared library with a reference command line tool for managing bootable, immutable, versioned filesystem trees."

LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=5f30f0716dfdd0d91eb439ebec522ec2"

inherit autotools pkgconfig

SRC_URI = " \
    git://github.com/ostreedev/ostree.git \
    file://Mount-boot-partition.patch \
    file://ostree-prepare-root-enabler-for-simpler-kernel-arg.patch \
    file://deploy-add-karg-none-argument.patch \
    file://Support-for-booting-without-initramfs.patch \
    file://Allow-updating-files-in-the-boot-directory.patch \
    file://u-boot-add-bootdir-to-the-generated-uEnv.txt.patch \
    file://Create-firmware-convenience-symlinks.patch \
    file://Print-pull-progress-also-when-not-on-console.patch \
    file://Workaround-the-SIGCHLD-handler-issue.patch \
    file://workaround-gtkdocize-configure-issue-in-autog.patch \
    file://u-boot-add-extra-bootargs-to-the-generated-uEnv.txt.patch \
    "

SRCREV = "8ece4d6d51bdbe3e41ab318259276bb83e553aa0"

S = "${WORKDIR}/git"

DEPENDS = "glib-2.0 glib-2.0-native e2fsprogs gpgme attr libsoup-2.4 libassuan xz libcap"
# Bash is needed by the shipped dracut module. This dracut module is used to generate initramfs image.
# The production image do not require bash for proper working.
RDEPENDS_${PN} += "bash"
RRECOMMENDS_${PN} += "gnupg"


EXTRA_OECONF = "--without-selinux \
                --without-libarchive \
                --with-builtin-grub2-mkconfig \
                --enable-rofiles-fuse=no \
                --enable-gtk-doc-html=no \
                --enable-man=no \
                --with-soup \
                --with-static-prepare-root \
                --disable-otmpfile \
                --enable-introspection=no \
                --enable-libsoup-client-certs"

do_configure_prepend() {
    cd ${S}
    # Update submodules and workaround bugs.
    env NOCONFIGURE=1 ./autogen.sh
    cd -
}
