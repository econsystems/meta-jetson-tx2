FILESEXTRAPATHS_prepend_poky := "${THISDIR}/${PN}:"

SRC_URI += "file://fw_env.config \
                "
do_install_append () {
install -m 0644 ${WORKDIR}/fw_env.config ${D}${sysconfdir}/fw_env.config
}

