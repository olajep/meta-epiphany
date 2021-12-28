S = "${TMPDIR}/work-shared/epiphany-gcc-${PV}-${PR}/git"

python () {
    old_configure_deps = d.getVarFlag('do_configure', 'depends', True) or ""
    new_configure_deps = old_configure_deps.replace('gcc-source-', 'epiphany-gcc-source-')
    d.setVarFlag('do_configure', 'depends', new_configure_deps)

    old_populate_lic_deps = d.getVarFlag('do_populate_lic', 'depends', True) or ""
    new_populate_lic_deps = old_populate_lic_deps.replace('gcc-source-', 'epiphany-gcc-source-')
    d.setVarFlag('do_populate_lic', 'depends', new_populate_lic_deps)
}
