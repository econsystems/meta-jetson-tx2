CRIPTION = "Interface test for Jetson-TX2 board"
LICENSE = "Proprietary"
SECTION="jetson-tx2"

LIC_FILES_CHKSUM = "file://ostree-conf-parser.sh;md5=cf71f2c9f063226db4c5faac67b2ac97"
PR = "r3"

#INSANE_SKIP_${PN}-dev = "ldflags"
RDEPENDS_${PN} = "bash"

SRC_URI = "\
	file://ostree-conf-parser.sh    \
	file://stopwatchdog.sh		\
"

S = "${WORKDIR}"

do_install () {
	install -d ${D}/home
        install -d ${D}/home/root
	install -m 0755 ${WORKDIR}/stopwatchdog.sh ${D}/home/root
        install -m 0755 ${WORKDIR}/ostree-conf-parser.sh ${D}/home/root
}

FILES_${PN} += "\
	 /home/root/stopwatchdog.sh          \
        /home/root/ostree-conf-parser.sh \
"
