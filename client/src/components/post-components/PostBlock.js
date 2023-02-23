import { useState } from "react";
import {ReactComponent as UpVote} from "../../assets/ic_upvote.svg";
import {ReactComponent as DownVote} from "../../assets/ic_downvote.svg";
import TagList from "../TagList";

function Vote({ fetchedVote }) {
  const [vote, setVote] = useState(fetchedVote);
  
  return (
    <div className="flex flex-col justify-center items-center relative gap-4">
      <UpVote onClick={() => setVote(vote+1)} />
      <p className="flex-grow-0 flex-shrink-0 text-center text-black text-xl">{vote}</p>
      <DownVote onClick={() => setVote(vote-1)} />
    </div>
  );
}

function BlockBody({fetchedBody}) {
  return (
    <>
      {fetchedBody}
    </>
  );
}

function PostBlock({content}) {
  return (
    <div className="flex">
      <Vote fetchedVote={content.votes} />
      <div className="flex flex-col">
        <BlockBody fetchedBody={content.content} />
        {/* Question인 경우에만 Tag가 존재하기 때문에, 존재할 때만 TagList를 렌더링 */}
        {content.tags ? <TagList fetchedTags={content.tags} /> : ''}
        <div className="flex justify-between">
          <p className="text-[#8B9197]">Edit</p>
          <div className="w-44 h-14 border-2">
            작성자 정보 영역, <br />
            추후 구현
          </div>
        </div>
        <p className="text-[#8B9197]">Add a comment</p>
      </div>
    </div>
  )
}

export default PostBlock