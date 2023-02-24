import '@toast-ui/editor/dist/toastui-editor.css'
import ToastUi from '@toast-ui/editor';
import { useEffect } from "react";

function Editor() {
  // const editorRef = useRef(null);
  //eslint-disable-next-line no-undef

  useEffect(() => {
    const editor = new ToastUi({
      el: document.querySelector('#editor'),
      previewStyle: 'vertical',
      height: '400px',
      initialEditType: 'markdown',
      initialValue: 'hello',
    });
    editor.getMarkdown();
  }, []);


  return (
    <div id='editor'/>
  );
};

export default Editor;
