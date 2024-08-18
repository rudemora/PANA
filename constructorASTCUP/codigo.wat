(module
(type $_sig_i32i32i32 (func (param i32 i32 i32) ))
(type $_sig_i32ri32 (func (param i32) (result i32)))
(type $_sig_i32 (func (param i32)))
(type $_sig_f32 (func (param f32)))
(type $_sig_ri32 (func (result i32)))
(type $_sig_rf32 (func (result f32)))

(type $_sig_void (func ))
(import "runtime" "exceptionHandler" (func $exception (type $_sig_i32)))
(import "runtime" "print" (func $printi32 (type $_sig_i32)))
(import "runtime" "print" (func $printf32 (type $_sig_f32)))

(import "runtime" "read" (func $readi32 (type $_sig_ri32)))
(import "runtime" "read" (func $readf32 (type $_sig_rf32)))
(memory 2000)   ;; TODO: Esto se cambia imagino
(global $SP (mut i32) (i32.const 0)) ;; start of stack
(global $MP (mut i32) (i32.const 0)) ;; mark pointer
(global $NP (mut i32) (i32.const 131071996)) ;; heap 2000*64*1024-4
(start $principal)
(func $principal (type $_sig_void)
	(local $localsStart i32)
	(local $temp i32)
	i32.const 16
	call $reserveStack
	local.set $temp
	global.get $MP
	local.get $temp
	i32.store
	global.get $MP
	i32.const 4
	i32.add
	local.set $localsStart








	call $main
	i32.load
	call $printi32
	call $freeStack
)
(func $main (result i32)
	(local $localsStart i32)
	(local $temp i32)
	i32.const 48
	call $reserveStack
	local.set $temp
	global.get $MP
	local.get $temp
	i32.store
	global.get $MP
	i32.const 4
	i32.add
	local.set $localsStart

	i32.const 4
	i32.const 0
	local.get $localsStart
	i32.add
	i32.const 3
	call $copyn


	call $readi32

	i32.const 1
	i32.const 6
	i32.gt_s
	if
	i32.const 1
	call $exception
	end
	i32.const 1
	i32.const 1
	i32.lt_s
	if
	i32.const 2
	call $exception
	end
	i32.const 12
	local.get $localsStart
	i32.add
	i32.const 1
	i32.const 1
	i32.const 1
	i32.sub
	i32.mul
	i32.const 4
	i32.mul
	i32.add
	i32.const 40
	call $reserveHeap
	global.get $NP
	i32.store

	i32.const 6
	i32.const 10
	i32.gt_s
	if
	i32.const 1
	call $exception
	end
	i32.const 6
	i32.const 1
	i32.lt_s
	if
	i32.const 2
	call $exception
	end
	i32.const 1
	i32.const 6
	i32.gt_s
	if
	i32.const 1
	call $exception
	end
	i32.const 1
	i32.const 1
	i32.lt_s
	if
	i32.const 2
	call $exception
	end
	i32.const 12
	local.get $localsStart
	i32.add
	i32.const 1
	i32.const 1
	i32.const 1
	i32.sub
	i32.mul
	i32.const 4
	i32.mul
	i32.add
	i32.load
	i32.const 1
	i32.const 6
	i32.const 1
	i32.sub
	i32.mul
	i32.const 4
	i32.mul
	i32.add
	f32.const 10.8
	f32.store

	i32.const 0
	local.get $localsStart
	i32.add
	i32.const 4
	i32.add
	i32.const 0
	i32.store

	i32.const 0
	local.get $localsStart
	i32.add
	i32.const 8
	i32.add
	i32.const 40
	call $reserveHeap
	global.get $NP
	i32.store

	i32.const 40
	local.get $localsStart
	i32.add
	i32.const 0
	local.get $localsStart
	i32.add
	i32.const 8
	i32.add
	global.get $SP
	i32.const 04
	i32.add
	i32.const 1
	call $copyn
	call $inicializarNotas
	f32.load
	f32.store

	i32.const 40
	local.get $localsStart
	i32.add
	f32.load
	call $printf32

	global.get $SP
	i32.const 4
	i32.sub
	i32.const 40
	local.get $localsStart
	i32.add
	f32.load
	call $decToInt
	i32.store
	global.get $SP
	i32.const 4
	i32.sub
	call $freeStack
	return
)




(func $mejoresN (result i32)
	(local $localsStart i32)
	(local $temp i32)
	i32.const 64
	call $reserveStack
	local.set $temp
	global.get $MP
	local.get $temp
	i32.store
	global.get $MP
	i32.const 4
	i32.add
	local.set $localsStart


	i32.const 48
	local.get $localsStart
	i32.add
	f32.const 100.1
	f32.store

	i32.const 52
	local.get $localsStart
	i32.add
	i32.const 1
	i32.store
	block
	 loop
	i32.const 52
	local.get $localsStart
	i32.add
	i32.load
	i32.const 40
	local.get $localsStart
	i32.add
	i32.load
	i32.const 1
	i32.add
	i32.le_s
 i32.eqz
 br_if 1
	i32.const 44
	local.get $localsStart
	i32.add
	i32.const 44
	local.get $localsStart
	i32.add
	f32.load
	i32.const 52
	local.get $localsStart
	i32.add
	i32.load
	i32.const 10
	i32.gt_s
	if
	i32.const 1
	call $exception
	end
	i32.const 52
	local.get $localsStart
	i32.add
	i32.load
	i32.const 1
	i32.lt_s
	if
	i32.const 2
	call $exception
	end
	i32.const 0
	local.get $localsStart
	i32.add
	i32.const 1
	i32.const 52
	local.get $localsStart
	i32.add
	i32.load
	i32.const 1
	i32.sub
	i32.mul
	i32.const 4
	i32.mul
	i32.add
	f32.load
	f32.add
	f32.store
	i32.const 48
	local.get $localsStart
	i32.add
	f32.load
	i32.const 52
	local.get $localsStart
	i32.add
	i32.load
	i32.const 10
	i32.gt_s
	if
	i32.const 1
	call $exception
	end
	i32.const 52
	local.get $localsStart
	i32.add
	i32.load
	i32.const 1
	i32.lt_s
	if
	i32.const 2
	call $exception
	end
	i32.const 0
	local.get $localsStart
	i32.add
	i32.const 1
	i32.const 52
	local.get $localsStart
	i32.add
	i32.load
	i32.const 1
	i32.sub
	i32.mul
	i32.const 4
	i32.mul
	i32.add
	f32.load
	f32.gt
	if
	i32.const 52
	local.get $localsStart
	i32.add
	i32.load
	i32.const 10
	i32.gt_s
	if
	i32.const 1
	call $exception
	end
	i32.const 52
	local.get $localsStart
	i32.add
	i32.load
	i32.const 1
	i32.lt_s
	if
	i32.const 2
	call $exception
	end
	i32.const 0
	local.get $localsStart
	i32.add
	i32.const 1
	i32.const 52
	local.get $localsStart
	i32.add
	i32.load
	i32.const 1
	i32.sub
	i32.mul
	i32.const 4
	i32.mul
	i32.add
	i32.const 48
	local.get $localsStart
	i32.add
	i32.const 1
	call $copyn
	else
	end
	i32.const 52
	local.get $localsStart
	i32.add
	i32.load
	i32.const 10
	i32.gt_s
	if
	i32.const 1
	call $exception
	end
	i32.const 52
	local.get $localsStart
	i32.add
	i32.load
	i32.const 1
	i32.lt_s
	if
	i32.const 2
	call $exception
	end
	i32.const 0
	local.get $localsStart
	i32.add
	i32.const 1
	i32.const 52
	local.get $localsStart
	i32.add
	i32.load
	i32.const 1
	i32.sub
	i32.mul
	i32.const 4
	i32.mul
	i32.add
	f32.load
	call $printf32
	i32.const 52
	local.get $localsStart
	i32.add
	i32.const 52
	local.get $localsStart
	i32.add
	i32.load
	i32.const 1
	i32.add
	i32.store
	 br 0
	 end
	end

	i32.const 44
	local.get $localsStart
	i32.add
	i32.const 44
	local.get $localsStart
	i32.add
	f32.load
	i32.const 48
	local.get $localsStart
	i32.add
	f32.load
	f32.sub
	f32.store

	global.get $SP
	i32.const 4
	i32.sub
	i32.const 44
	local.get $localsStart
	i32.add
	f32.load
	i32.const 40
	local.get $localsStart
	i32.add
	i32.load
	call $intToDec
	f32.div
	f32.store
	global.get $SP
	i32.const 4
	i32.sub
	call $freeStack
	return
)

(func $inicializarNotas (result i32)
	(local $localsStart i32)
	(local $temp i32)
	i32.const 28
	call $reserveStack
	local.set $temp
	global.get $MP
	local.get $temp
	i32.store
	global.get $MP
	i32.const 4
	i32.add
	local.set $localsStart

	i32.const 4
	local.get $localsStart
	i32.add
	i32.const 1
	i32.store


	local.get $localsStart
	i32.const 12
	i32.add
	i32.const 4
	i32.store
	block
	 loop
	local.get $localsStart
	i32.const 12
	i32.add
	i32.load
	 i32.eqz
	 br_if 1
	i32.const 16
	local.get $localsStart
	i32.add
	call $readf32
	f32.store
	i32.const 16
	local.get $localsStart
	i32.add
	i32.const 4
	local.get $localsStart
	i32.add
	i32.load
	i32.const 10
	i32.gt_s
	if
	i32.const 1
	call $exception
	end
	i32.const 4
	local.get $localsStart
	i32.add
	i32.load
	i32.const 1
	i32.lt_s
	if
	i32.const 2
	call $exception
	end
	i32.const 0
	local.get $localsStart
	i32.add
	i32.load
	i32.const 1
	i32.const 4
	local.get $localsStart
	i32.add
	i32.load
	i32.const 1
	i32.sub
	i32.mul
	i32.const 4
	i32.mul
	i32.add
	i32.const 1
	call $copyn
	i32.const 4
	local.get $localsStart
	i32.add
	i32.load
	i32.const 10
	i32.gt_s
	if
	i32.const 1
	call $exception
	end
	i32.const 4
	local.get $localsStart
	i32.add
	i32.load
	i32.const 1
	i32.lt_s
	if
	i32.const 2
	call $exception
	end
	i32.const 0
	local.get $localsStart
	i32.add
	i32.load
	i32.const 1
	i32.const 4
	local.get $localsStart
	i32.add
	i32.load
	i32.const 1
	i32.sub
	i32.mul
	i32.const 4
	i32.mul
	i32.add
	f32.load
	call $printf32
	i32.const 8
	local.get $localsStart
	i32.add
	i32.const 8
	local.get $localsStart
	i32.add
	f32.load
	i32.const 16
	local.get $localsStart
	i32.add
	f32.load
	f32.add
	f32.store
	i32.const 4
	local.get $localsStart
	i32.add
	i32.const 4
	local.get $localsStart
	i32.add
	i32.load
	i32.const 1
	i32.add
	i32.store
	local.get $localsStart
	i32.const 12
	i32.add
	local.get $localsStart
	i32.const 12
	i32.add
	i32.load
	i32.const 1
	i32.sub
	i32.store
	 br 0
	 end
	end

	global.get $SP
	i32.const 4
	i32.sub
	i32.const 0
	local.get $localsStart
	i32.add
	i32.load
	global.get $SP
	i32.const 04
	i32.add
	i32.const 10
	call $copyn
	global.get $SP
	i32.const 44
	i32.add
	i32.const 3
	i32.store
	call $mejoresN
	f32.load
	f32.store
	global.get $SP
	i32.const 4
	i32.sub
	call $freeStack
	return
)




 ;;FUNCIONES DEFINIDAS
(func $reserveStack (param $size i32)
   (result i32)
   global.get $MP
   global.get $SP
   global.set $MP
   global.get $SP
   local.get $size
   i32.add
   global.set $SP
   global.get $SP
   global.get $NP
   i32.gt_u
   if
   i32.const 3
   call $exception
   end
)
(func $freeStack (type $_sig_void)
   global.get $MP
   global.set $SP
   global.get $MP
   i32.load
   global.set $MP   
)
(func $reserveHeap (type $_sig_i32)
   (param $size i32)
   global.get $NP
   local.get $size
   i32.sub
   global.set $NP
   global.get $SP
   global.get $NP
   i32.gt_u
   if
   i32.const 3
   call $exception
   end

)
(func $copyn (type $_sig_i32i32i32) ;; copy $n i32 slots from $src to $dest
   (param $src i32)
   (param $dest i32)
   (param $n i32)
   block
     loop
       local.get $n
       i32.eqz
       br_if 1
       local.get $n
       i32.const 1
       i32.sub
       local.set $n
       local.get $dest
       local.get $src
       i32.load
       i32.store
       local.get $dest
       i32.const 4
       i32.add
       local.set $dest
       local.get $src
       i32.const 4
       i32.add
       local.set $src
       br 0
     end
   end
)

(func $decToInt (param $para f32) (result i32)
    local.get $para
    i32.trunc_f32_s
return 
  )

 (func $intToDec (param $para i32) (result f32)
    local.get $para
    f32.convert_i32_s
return
 )


(func $repeat (param $para i32) (result i32 i32)
	local.get $para
	local.get $para
)

(func $repeatf32 (param $para f32) (result f32 f32)
	local.get $para
	local.get $para
)

(export "memory" (memory 0))
(export "init" (func $principal))
)