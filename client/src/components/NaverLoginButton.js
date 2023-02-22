/* eslint-disable */
import { useRef,useEffect } from 'react';
import ic_naver from '../assets/icon_naver.png';

const NaverLoginButton = () => {
  const naverRef = useRef(null);
  const { naver } = window;

  const NAVER_CLIENT_ID = process.env.REACT_APP_NAVER_CLIENT_ID// 발급 받은 Client ID 입력 
	const NAVER_CALLBACK_URL = process.env.REACT_APP_NAVER_CALLBACK_URL // 작성했던 Callback URL 입력

  const initializeNaverLogin = () => {
    const naverLogin = new naver.LoginWithNaverId({
      clientId: NAVER_CLIENT_ID,
      callbackUrl: NAVER_CALLBACK_URL,
      isPopup: false,
      loginButton: { color: 'green', type: 3, height: 60 },
    });
    naverLogin.init();
  };

  useEffect(() => {
    initializeNaverLogin();
  }, [])

  const handleNaverLogin = () => {    
    naverRef.current.children[0].click();
  };

  return (
    <>
      <button ref={naverRef} id="naverIdLogin" className='hidden' />
      <button
        className="cursor-pointer flex justify-start items-center flex-grow-0 flex-shrink-0 w-[288.45px] h-[37.8px] gap-[7px] px-[82px] py-[9px] rounded-[5px] bg-[#22c75a] border-[0.5px] border-[#9fa6ad]"
        onClick={handleNaverLogin}
      >
        <img
          src={ic_naver}
          className="flex-grow-0 flex-shrink-0 w-[18px] h-[16.2px] object-cover"
          alt=""
        />
        <p className="flex-grow-0 flex-shrink-0 text-[13px] font-medium text-center text-white">
          Log in with Naver
        </p>
      </button>
    </>
  );
};

export default NaverLoginButton;
