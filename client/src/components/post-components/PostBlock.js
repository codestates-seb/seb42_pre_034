import { useState } from "react";
import {ReactComponent as UpVote} from "../../assets/ic_upvote.svg";
import {ReactComponent as DownVote} from "../../assets/ic_downvote.svg";

function Vote({ fetchedVote }) {
  const [vote, setVote] = useState(fetchedVote);
  
  return (
    <div className="flex flex-col justify-center items-center relative gap-4">
      <UpVote onClick={() => setVote(vote+1)} />
      <p className="flex-grow-0 flex-shrink-0 text-center text-black">{vote}</p>
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
      <div>
        <BlockBody fetchedBody={content.content} />
      </div>
    </div>
  )
}

export default PostBlock