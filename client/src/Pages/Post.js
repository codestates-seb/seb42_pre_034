import StackButton from '../components/StackButton';
import PostBlock from '../components/post-components/PostBlock';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import Loading from '../components/Loading';

/**
 * 질문 클릭 시 표시되는 상세 페이지
 * 포함하는 컴포넌트들은 components/post-components 폴더에서 작성
 */

function Post() {
  const params = useParams();
  const [postContent, setPostContent] = useState({});
  const [isLoading, setIsLoading] = useState(true);

  function getTimeDifferenceString(pastTime) {
    const ONE_DAY_MS = 24 * 60 * 60 * 1000; // Number of milliseconds in one day
    const ONE_MONTH_MS = 30 * ONE_DAY_MS; // Number of milliseconds in one month
    const ONE_YEAR_MS = 365 * ONE_DAY_MS; // Number of milliseconds in one year
  
    pastTime = new Date(pastTime);
    const currentTime = new Date();
    const timeDiffMs = currentTime - pastTime;
  
    if (timeDiffMs < ONE_DAY_MS) {
      return 'today';
    } else if (timeDiffMs < ONE_YEAR_MS) {
      const numDays = Math.floor(timeDiffMs / ONE_DAY_MS);
      return `${numDays} day${numDays === 1 ? '' : 's'}`;
    } else if (timeDiffMs < ONE_YEAR_MS + ONE_MONTH_MS) {
      const numMonths = Math.floor(timeDiffMs / ONE_MONTH_MS);
      const numDays = Math.floor((timeDiffMs - numMonths * ONE_MONTH_MS) / ONE_DAY_MS);
      return `${numMonths} month${numMonths === 1 ? '' : 's'}, ${numDays} day${numDays === 1 ? '' : 's'}`;
    } else {
      const numYears = Math.floor(timeDiffMs / ONE_YEAR_MS);
      const numMonths = Math.floor((timeDiffMs - numYears * ONE_YEAR_MS) / ONE_MONTH_MS);
      return `${numYears} year${numYears === 1 ? '' : 's'}, ${numMonths} month${numMonths === 1 ? '' : 's'}`;
    }
  }  

  // 페이지 이동 후 화면 표시
  useEffect(() => {
    axios.get(`http://localhost:8000/questions/${params.id}`)
      .then((res) => {
        setPostContent(res.data);
        setIsLoading(false);
      })
      .catch((err) => {
        console.log(err);
      })
  }, []);

  if (isLoading) return <Loading />

  return (
    <div className='flex flex-col w-full px-8'>
      {/* Post header */}
      <header className='flex flex-col mb-4'>
        <div className='flex justify-between my-4'>
          {/* TODO: 제목 부분을 받아온 데이터로 표시하도록 수정 */}
          <h1 className='text-4xl'>How to write better code than ChatGPT</h1>
          <StackButton label="Ask Question"/>
        </div>
        <div className='flex items-center gap-4 '>
          <div className='flex justify-center items-center text-sm'>
            <p className='text-[#8B9197] mr-1'>Asked</p>
            <p>{getTimeDifferenceString(postContent.createdAt)}</p>
          </div>
          <div className='flex justify-center items-center text-sm'>
            <p className='text-[#8B9197] mr-1'>Modified</p>
            <p>{getTimeDifferenceString(postContent.modifiedAt)}</p>
          </div>
          <div className='flex justify-center items-center text-sm'>
            <p className='text-[#8B9197] mr-1'>Viewed</p>
            <p>{postContent.view} times</p>
          </div>
        </div>
      </header>
      <article className='flex flex-col border-t-[3px] border-[#f1f2f3] pt-4'>
        <PostBlock content={postContent} />
        <StackButton label="Post Your Answer" />
      </article>
    </div>
  )
}

export default Post