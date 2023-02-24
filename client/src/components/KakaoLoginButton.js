/* eslint-disable */
import axios from 'axios';
import { ReactComponent as IC_LOGIN_KAKAO } from '../assets/ic_login_kakao.svg';

const KakaoLoginButton = () => {
  const handleKaKaoLogin = async () => {
    try {
      const response = await axios.get(
        `${process.env.REACT_APP_SERVER_URL}/oauth2/authorization/kakao`,
        {},
        { withCredentials: true }
      );
      // 카카오 소셜로그인 창으로 이동합니다.
      window.location.href = response.data.redirectUrl;
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <>
      <button
        className="cursor-pointer flex justify-start items-center flex-grow-0 flex-shrink-0 w-[288.45px] h-[37.8px] gap-[7px] px-[82px] py-[9px] rounded-[5px] bg-[#fee500] border-[0.5px] border-[#9fa6ad]"
        onClick={handleKaKaoLogin}
      >
        <IC_LOGIN_KAKAO />
        <p className="flex-grow-0 flex-shrink-0 text-[13px] font-medium text-center text-[#3b4045]">
          Log in with KaKao
        </p>
      </button>
    </>
  );
};

export default KakaoLoginButton;
