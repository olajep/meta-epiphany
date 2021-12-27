FILESEXTRAPATHS_prepend := "${THISDIR}/epiphany-elf-gcc:"

SRC_URI += " \
    file://0001-Merged-updated-old-alias.c-patch-current-testcase-is.patch \
    file://0002-ChangeLog.epiphany-Add-reference-to-PR-rtl-optimizat.patch \
    file://0003-config-epiphany-epiphany.h-ASM_OUTPUT_SYMBOL_REF-Def.patch \
    file://0004-Overlay-fpic-support.patch \
    file://0005-epiphany-Add-TRACE_REGNUM.patch \
    file://0006-epiphany-Use-need_trace-instead-of-TRACE_REGNUM.patch \
    file://0007-config-epiphany-epiphany.c-epiphany_compute_frame_si.patch \
    file://0008-config-epiphany-epiphany.c-set_lr_slot_offset-For-fr.patch \
    file://0009-config-epiphany-predicates.md-trace_operand-Verify-t.patch \
    file://0010-config-epiphany-predicates.md-pcrel_operand-New-pred.patch \
    file://0011-config-epiphany-epiphany.c-epiphany_expand_epilogue-.patch \
    file://0012-config-epiphany-epiphany.h-EPIPHANY_LIBRARY_EXTRA_SP.patch \
    file://0013-config-epiphany-epiphany.md-GPR_FP-Change-to-11.patch \
    file://0014-config-epiphany-epiphany.h-EPIPHANY_LIBRARY_EXTRA_SP.patch \
    file://0015-config-epiphany-epiphany.h-ENDFILE_SPEC-Add-cacheman.patch \
    file://0016-Fix-software-cache-flag-issues.patch \
    file://0017-config-epiphany-epiphany.md-stack_adjust_addfp-stack.patch \
    file://0018-Fix-casesi_load-jump_table_data-SNAFU.patch \
    file://0019-Link-with-cachemanager.o-for-Epiphany-when-fpic-is-u.patch \
    file://0020-gcc.patch \
    file://0021-epiphany-Move-frame-pointer-to-register-15.patch \
    file://0022-epiphany-Change-USER_LABEL_PREFIX-to.patch \
    file://0023-epiphany-Enable-mno-soft-cmpsf-under-ffast-math.patch \
    file://0024-epiphany-Emit-type-and-size-for-functions.patch \
    file://0025-epiphany-Add-underscore-prefix-to-init-and-fini.patch \
    file://0026-libgcc-epiphany-crti.S-Respect-__USER_LABEL_PFREFIX_.patch \
    file://0027-gcc-epiphany-Let-assembler-generate-debug-line-info.patch \
    file://0028-gcc-epiphany-Fix-test-cases.patch \
    file://0029-epiphany-Emit-config-save-register-right-after-prolo.patch \
    file://0030-epiphany-Make-r32-r43-caller-saved.patch \
    file://0031-epiphany-Add-mno-sched-prolog-option.patch \
    file://0032-libgcc-epiphany-Use-registers-marked-in-epiphany.md-.patch \
    file://0033-epiphany-Fix-fsoftware-cache-description.patch \
    file://0034-epiphany-Fix-compile-errors.patch \
"
