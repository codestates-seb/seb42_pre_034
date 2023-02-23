function StackButton({ label }) {
  return (
    <div className="float-right w-[100px] h-10 relative overflow-hidden gap-2.5 py-2.5 rounded-[10px] bg-[#601bb3]">
      <p className="text-[13px] font-bold text-center text-white">
        {label}
      </p>
    </div>
  )
}

export default StackButton