import StackButton from '../components/StackButton';
import PostBlock from '../components/post-components/PostBlock';

/**
 * 질문 클릭 시 표시되는 상세 페이지
 * 포함하는 컴포넌트들은 components/post-components 폴더에서 작성
 */

function Post() {
  const dummyContent = {
    body: "I want to be a very valuable front-end engineer. How do you do that? I think about it. If I can write better code than ChatGPT, will I become a very valuable front-end engineer",
    votes: -1,
    tags: ["career", "chatgpt", "ai"],
    author: "dev4jaehunkim"
  }

  return (
    <div className='flex flex-col w-full px-8'>
      {/* Post header */}
      <header className='flex flex-col mb-4'>
        <div className='flex justify-between my-4'>
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
      <article className='flex flex-col border-t-[3px] border-[#f1f2f3] pt-4'>
        <PostBlock content={dummyContent} />
        <StackButton label="Post Your Answer" />
      </article>
      
    </div>
  )
}

export default Post