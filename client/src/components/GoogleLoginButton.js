/* eslint-disable */
import { ReactComponent as IC_LOGIN_GOOGLE } from '../assets/ic_login_google.svg';

const GoogleLoginButton = () => {
  const handleGoogleLogin = async () => {
    window.location.href = `${process.env.REACT_APP_SERVER_URL}/oauth2/authorization/google`;
  };

  return (
    <>
      <button className="cursor-pointer flex justify-start items-center flex-grow-0 flex-shrink-0 w-[288.45px] h-[37.8px] gap-[7px] px-[82px] py-[9px] rounded-[5px] bg-white border-[0.5px] border-[#9fa6ad]"
      onClick={handleGoogleLogin}
      >
          <IC_LOGIN_GOOGLE />
          <p className="flex-grow-0 flex-shrink-0 text-[13px] font-medium text-center text-[#3b4045]">
            Log in with Google
          </p>
        </button>

    </>
  );
};

export default GoogleLoginButton;
