import { useRef } from 'react';
import {Editor} from '@toast-ui/react-editor'
import '@toast-ui/editor/dist/toastui-editor.css'
import axios from 'axios';

function ToastEditor() {
  // Editor DOM 선택용
  const editorRef = useRef();

  // 등록 버튼 핸들러
  const handleRegisterButton = () => {
    
    axios.post('http://ec2-3-36-115-159.ap-northeast-2.compute.amazonaws.com:8080/questions', {
      // 타이틀 작성하는 것이 없어 더미로 test title 입력
      title: "test title",
      //  입력한 내용을 MarkDown 형태로 취득
      content: editorRef.current?.getInstance().getMarkdown()
    })
      // 응답 코드 출력
      .then(res => {
        console.log(res)
      })
      // 에러 메시지 출력
      .catch(err => {
        console.log(err);
      });
  };

    return (
      <div>
        <Editor
            ref={editorRef} // DOM 선택용 useRef
            placeholder="내용을 입력해주세요."
            previewStyle="vertical" // 미리보기 스타일 지정
            height="300px" // 에디터 창 높이
            initialEditType="wysiwyg" //
            initialValue=' '
            toolbarItems={[
              // 툴바 옵션 설정
              ['heading', 'bold', 'italic', 'strike'],
              ['hr', 'quote'],
              ['ul', 'ol', 'task', 'indent', 'outdent'],
              ['table', 'image', 'link'],
              ['code', 'codeblock']
            ]}
        ></Editor>
      <button onClick={handleRegisterButton}>등록</button>
      </div>
  );
};

export default ToastEditor;
