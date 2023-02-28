import '@toast-ui/editor/dist/toastui-editor.css'
import ToastUi from '@toast-ui/editor';
import { useEffect } from "react";

function Editor({ options }) {
  // const editorRef = useRef(null);
  //eslint-disable-next-line no-undef

  useEffect(() => {
    const editor = new ToastUi({
      el: document.querySelector(`#${options.id}`),
      previewStyle: 'vertical',
      height: options.height || '400px',
      initialEditType: 'markdown',
      initialValue: options.init || 'Hi!!',
    });
    editor.getMarkdown();
  }, []);


  return (
    <div id={options.id}/>
  );
};

export default Editor;
