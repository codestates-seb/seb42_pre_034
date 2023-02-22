/* eslint-disable */
import { useDispatch } from 'react-redux';
import { loginWithNaver } from '../Store/authSlice';
import ic_naver from '../assets/icon_naver.png';

const NaverLoginButton = () => {
  const dispatch = useDispatch();

  const handleNaverLogin = async () => {
    try {
      const clientId = process.env.REACT_APP_NAVER_CLIENT_ID;
      const redirectUri = process.env.REACT_APP_NAVER_REDIRECT_URI;
      const responseType = 'code';
      const state = Math.random().toString(36).substr(2, 11);
      const apiUrl = `https://nid.naver.com/oauth2.0/authorize?client_id=${clientId}&redirect_uri=${redirectUri}&response_type=${responseType}&state=${state}`;
      let left = Math.ceil(( window.screen.width)/2);
      let top = Math.ceil(( window.screen.height)/2); 
      
      const popup = window.open(apiUrl, 'naver-login-popup', `top=${top},left=${left}`);
      const intervalId = setInterval(() => {
        if (popup.closed) {
          clearInterval(intervalId);
          const url = popup.location.href;
          const code = url.match(/code=([^&]*)/)[1];
          dispatch(loginWithNaver(code));
        }
      }, 500);
    } catch (error) {
      console.log(error);
    }
  };

  return (
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
  );
};

export default NaverLoginButton;
