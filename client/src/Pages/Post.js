import StackButton from '../components/StackButton';

/**
 * 질문 클릭 시 표시되는 상세 페이지
 * 포함하는 컴포넌트들은 components/post-components 폴더에서 작성
 */

function Post() {
  return (
    <>
      This post id is 
      <StackButton label="Ask Question" />
      <StackButton label="Post Your Answer" />
    </>
  )
}

export default Post