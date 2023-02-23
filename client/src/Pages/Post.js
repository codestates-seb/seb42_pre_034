import StackButton from '../components/StackButton';

/**
 * 질문 클릭 시 표시되는 상세 페이지
 * 포함하는 컴포넌트들은 components/post-components 폴더에서 작성
 */

function Post() {
  return (
    <div className='flex flex-col w-full'>
      {/* Post header */}
      <header className='flex flex-col pl-8'>
        <div className='flex justify-between w-11/12 my-4'>
          {/* TODO: 제목 부분을 받아온 데이터로 표시하도록 수정 */}
          <h1 className='text-2xl'>How to write better code than ChatGPT</h1>
          <StackButton label="Ask Question"/>
        </div>
        <div className='flex items-center gap-4 '>
          <div className='flex justify-center items-center text-sm'>
            <p className='text-[#8B9197] mr-1'>Asked</p>
            {/* TODO: 서버에서 받아온 날짜로부터 계산된 값을 표시하기 */}
            <p>Today</p>
          </div>
          <div className='flex justify-center items-center text-sm'>
            <p className='text-[#8B9197] mr-1'>Modified</p>
            {/* TODO: 서버에서 받아온 날짜로부터 계산된 값을 표시하기 */}
            <p>Today</p>
          </div>
          <div className='flex justify-center items-center text-sm'>
            <p className='text-[#8B9197] mr-1'>Viewed</p>
            {/* TODO: 숫자 부분만 서버에서 받아온 조회수로 표시하기 */}
            <p>18 times</p>
          </div>
        </div>
        
      </header>
      <article className='flex flex-col'>
        This post id is 
        <StackButton label="Post Your Answer" />
      </article>
      
    </div>
  )
}

export default Post