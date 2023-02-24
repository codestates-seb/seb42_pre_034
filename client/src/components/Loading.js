function Loading() {
  return (
    <div className="flex flex-col w-full h-1/2 justify-center items-center gap-4">
      {/* border-t-transparent는 top border만 배경색과 일치 시킨다는 의미 */}
      <div aria-hidden="true" className="animate-spin w-12 h-12 border-solid border-4 rounded-full border-[#742AB7] border-t-transparent border-r-transparent">
      </div>
      <h1>Loading...</h1>
    </div>
  );
}

export default Loading;