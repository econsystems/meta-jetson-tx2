PR = "r0"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://watchdog-test.c;md5=8eeea2de262f0f72da37c8f971d681aa"
SRC_URI = "file://watchdog-test.c  \
	   "
inherit module

TARGET_CC_ARCH += "${LDFLAGS}"

S = "${WORKDIR}"
do_compile () {
	${CC} -v -o watchdog-test watchdog-test.c
}

do_install () {
	install -d ${D}/usr
	install -d ${D}/usr/bin
	install -m 0755 ${S}/watchdog-test ${D}/usr/bin
}

FILES_${PN} += "\
		/usr/bin/watchdog-test"
