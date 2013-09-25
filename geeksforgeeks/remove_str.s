	.section	__TEXT,__text,regular,pure_instructions
	.globl	_replace
	.align	4, 0x90
_replace:                               ## @replace
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp2:
	.cfi_def_cfa_offset 16
Ltmp3:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp4:
	.cfi_def_cfa_register %rbp
	movq	%rdi, -8(%rbp)
	movl	$0, -12(%rbp)
	movq	-8(%rbp), %rdi
	movq	%rdi, -24(%rbp)
LBB0_1:                                 ## =>This Inner Loop Header: Depth=1
	movq	-24(%rbp), %rax
	cmpb	$0, (%rax)
	je	LBB0_11
## BB#2:                                ##   in Loop: Header=BB0_1 Depth=1
	movq	-24(%rbp), %rax
	movsbl	(%rax), %ecx
	cmpl	$98, %ecx
	jne	LBB0_4
## BB#3:                                ##   in Loop: Header=BB0_1 Depth=1
	movq	-24(%rbp), %rax
	addq	$1, %rax
	movq	%rax, -24(%rbp)
	jmp	LBB0_10
LBB0_4:                                 ##   in Loop: Header=BB0_1 Depth=1
	movq	-24(%rbp), %rax
	movsbl	(%rax), %ecx
	cmpl	$99, %ecx
	jne	LBB0_8
## BB#5:                                ##   in Loop: Header=BB0_1 Depth=1
	movl	-12(%rbp), %eax
	subl	$1, %eax
	movslq	%eax, %rcx
	movq	-8(%rbp), %rdx
	movsbl	(%rdx,%rcx), %eax
	cmpl	$97, %eax
	jne	LBB0_8
## BB#6:                                ##   in Loop: Header=BB0_1 Depth=1
	cmpl	$0, -12(%rbp)
	jle	LBB0_8
## BB#7:                                ##   in Loop: Header=BB0_1 Depth=1
	movq	-24(%rbp), %rax
	addq	$1, %rax
	movq	%rax, -24(%rbp)
	movl	-12(%rbp), %ecx
	addl	$4294967295, %ecx       ## imm = 0xFFFFFFFF
	movl	%ecx, -12(%rbp)
	jmp	LBB0_9
LBB0_8:                                 ##   in Loop: Header=BB0_1 Depth=1
	movq	-24(%rbp), %rax
	movb	(%rax), %cl
	movslq	-12(%rbp), %rax
	movq	-8(%rbp), %rdx
	movb	%cl, (%rdx,%rax)
	movq	-24(%rbp), %rax
	addq	$1, %rax
	movq	%rax, -24(%rbp)
	movl	-12(%rbp), %esi
	addl	$1, %esi
	movl	%esi, -12(%rbp)
LBB0_9:                                 ##   in Loop: Header=BB0_1 Depth=1
	jmp	LBB0_10
LBB0_10:                                ##   in Loop: Header=BB0_1 Depth=1
	jmp	LBB0_1
LBB0_11:
	movslq	-12(%rbp), %rax
	movq	-8(%rbp), %rcx
	movb	$0, (%rcx,%rax)
	popq	%rbp
	ret
	.cfi_endproc

	.globl	_main
	.align	4, 0x90
_main:                                  ## @main
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp7:
	.cfi_def_cfa_offset 16
Ltmp8:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp9:
	.cfi_def_cfa_register %rbp
	subq	$32, %rsp
	movl	$0, -4(%rbp)
	movl	%edi, -8(%rbp)
	movq	%rsi, -16(%rbp)
	movl	L_main.str1(%rip), %edi
	movl	%edi, -20(%rbp)
	leaq	-20(%rbp), %rdi
	callq	_replace
	leaq	L_.str(%rip), %rdi
	leaq	-20(%rbp), %rsi
	movb	$0, %al
	callq	_printf
	movl	$0, %ecx
	movl	%eax, -24(%rbp)         ## 4-byte Spill
	movl	%ecx, %eax
	addq	$32, %rsp
	popq	%rbp
	ret
	.cfi_endproc

	.section	__TEXT,__cstring,cstring_literals
L_main.str1:                            ## @main.str1
	.asciz	 "abc"

L_.str:                                 ## @.str
	.asciz	 "%s\n"


.subsections_via_symbols
