SRC_URI += "file://u_boot_tegra186_econ_otasupport.patch"
do_compile_append() {
	oe_runmake clean
        oe_runmake p2771-0000-500_defconfig
        oe_runmake
}

