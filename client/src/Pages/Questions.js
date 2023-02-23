import cool from '../assets/cool.png';
import dummy from '../assets/dummy.json';
import StackButton from '../components/StackButton';
import { Link } from 'react-router-dom';
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
  return (
    <div className="h-screen pt-[20px] pl-[20px]">
      <div className='pb-[80px]'>
        <p className="text-[32px] font-medium text-left text-black">
          All Questions
        </p>
        <StackButton label="Ask Question" />
        <p className="text-xl text-left text-black">4 questions</p>
      </div>
      {dummy.questions.map((data) => (
        <div
          key={data.id}
          className="flex flex-col justify-center w-[1050px] h-[150px]  border-t-[3px] border-[#f1f2f3]"
        >
          <div className="flex flex-row p-0">
            {/* 투표, answer, views */}
            <div className="flex flex-col whitespace-nowrap pr-5">
              <span className="">-1 votes</span>
              <span className="">0 answers</span>
              <span className="">2 views</span>
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
                  <span>modified 1 mins ago</span>
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
