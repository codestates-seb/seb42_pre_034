import cool from '../assets/cool.png';
import StackButton from '../components/StackButton';
import { Link } from 'react-router-dom';
import { useEffect, useState } from 'react';
import axios from 'axios';


/*
 게시글 페이지 구현
게시글 페이지를 구현하기 위해 게시글 컴포넌트를 먼저 구현해야 합니다.

 질문 게시글은 1개의 질문과 0개 이상의 답변으로 이뤄집니다.
게시글 컴포넌트 구현
게시글 컴포넌트는 질문 목록에서 질문 글을 선택했을 때 이동되는 페이지에서 보여야 합니다.

 제목, 작성자, 내용 등이 잘 표시되도록 작성합니다.
 해당 컴포넌트 하나로 질문/답변을 모두 표시할 수 있어야 합니다.
 게시글 타입이 '답변'인 경우 답변 채택 버튼을 표시합니다.
 */
const Questions = () => {
  const [questionList, setQuestionList] = useState(null)
  useEffect(() => {
    axios.get('http://localhost:8080/questions')
      .then(data => {
        setQuestionList(data.data);
      })
      .catch(err => console.log(err));
  }, []);
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
  return (
    <div className="h-screen pt-[20px] pl-[20px]">
      <div className='pb-[80px]'>
        <p className="text-[32px] font-medium text-left text-black">
          All Questions
        </p>
        {/* Link to 추가 */}
        <Link to={'/ask'}>
          <StackButton label="Ask Question"/>
        </Link>
        <p className="text-xl text-left text-black">4 questions</p>
      </div>
      {questionList && questionList.map((data) => (
        <div
          key={data.id}
          className="flex flex-col justify-center w-[1050px] h-[150px]  border-t-[3px] border-[#f1f2f3]"
        >
          <div className="flex flex-row p-0">
            {/* 투표, answer, views */}
            <div className="flex flex-col whitespace-nowrap pr-5">
              <span className="">{data.votes} votes</span>
              <span className="">{data.answer ? data.answer.length : 0} answers</span>
              <span className="">{data.view} views</span>
            </div>

            <div className="flex flex-col pr-5">
              <Link to={`/${data.id}`}>
                <span className=" text-left text-[#0075cf]"> {data.title}</span>
              </Link>
              <span className="text-left text-black">{data.content}</span>

              <div className="flex flex-row justify-between">
                {/* 태그
                        태그 갯수에 따라서 밑에 span 증가
                    */}
                <div className="flex flex-row justify-start ">
                  <span className=" gap-2.5 px-[5px] py-0.5 text-center rounded-[3px] bg-[#e1ecf4] text-[#39739d] mr-1">
                    {data.tags[0]}
                  </span>
                  <span className=" gap-2.5 px-[5px] py-0.5 text-center rounded-[3px] bg-[#e1ecf4] text-[#39739d] mr-1">
                    {data.tags[1]}
                  </span>
                  <span className=" gap-2.5 px-[5px] py-0.5 text-center rounded-[3px] bg-[#e1ecf4] text-[#39739d] mr-1">
                    {data.tags[2]}
                  </span>
                </div>
                <div className="flex flex-row justify-start items-center">
                  <img src={cool} alt="" className="w-4 h-4 " />
                  <span className="text-[#0075cf] ml-1">username</span>
                  <span className="text-black ml-1">12.2k</span>
                  <span className="text-right text-[#93999f] ml-1"></span>
                  <span>{getTimeDifferenceString(data.modifiedAt)} ago</span>
                </div>
              </div>
              {/* username~ */}
            </div>
          </div>
        </div>
      ))}
    </div>
  );
};

export default Questions;
