/* eslint-disable */
import { useRef,useEffect } from 'react';
import axios from "axios";
import ic_naver from '../assets/icon_naver.png';

const NaverLoginButton = () => {
  
  const handleNaverLogin = () => {
    window.location.href = `${process.env.REACT_APP_SERVER_URL}/oauth2/authorization/naver`;
  };

  return (
    <>
      {/* <button ref={naverRef} id="naverIdLogin" className='hidden' /> */}
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
