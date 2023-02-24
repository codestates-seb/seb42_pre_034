/* eslint-disable */
import axios from "axios";
import IC_LOGIN_NAVER from '../assets/ic_login_naver.png';

const NaverLoginButton = () => {
  
  const handleNaverLogin = async () => {
    try {
      const response = await axios.get(`${process.env.REACT_APP_SERVER_URL}/oauth2/authorization/naver`,{},{withCredentials: true});
      // 네이버 소셜로그인 창으로 이동합니다.
      window.location.href = response.data.redirectUrl;
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <>
      {/* <button ref={naverRef} id="naverIdLogin" className='hidden' /> */}
      <button
        className="cursor-pointer flex justify-start items-center flex-grow-0 flex-shrink-0 w-[288.45px] h-[37.8px] gap-[7px] px-[82px] py-[9px] rounded-[5px] bg-[#22c75a] border-[0.5px] border-[#9fa6ad]"
        onClick={handleNaverLogin}
      >
        <img
          src={IC_LOGIN_NAVER}
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
