PREPEND_TARGET_PREFIX_TO_PN ??= "1"

# Prepend prefix to package names to avoid collisions with the default target
python () {
    if d.getVar("PREPEND_TARGET_PREFIX_TO_PN") != "1":
        return

    target_arch = d.getVar("TARGET_ARCH")
    orig_packages = (d.getVar("PACKAGES") or "").split()
    new_packages = []
    for orig_name in orig_packages:
        if target_arch in orig_name:
            new_name = orig_name
        else:
            new_name = target_arch + "-" + orig_name
        new_packages.append(new_name)
        files = d.getVar("FILES:" + orig_name) or ""
        d.delVar("FILES:" + orig_name)
        d.setVar("FILES:" + new_name, files)
    d.setVar("PACKAGES", " ".join(new_packages))
}
