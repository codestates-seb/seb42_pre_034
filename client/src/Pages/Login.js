import ic_naver from '../assets/icon_naver.png';
import { ReactComponent as IC_kakao } from '../assets/ic_kakao.svg';
import { ReactComponent as IC_google } from '../assets/ic_google.svg';
import { ReactComponent as IC_stackoverflow } from '../assets/ic_stackoverflow.svg';
import { ReactComponent as IC_share } from '../assets/ic_share.svg';

const Login = () => {
  return (
    <div className="w-[288.45px] h-[555.2px] relative select-none">
      <div className="flex justify-center items-start w-[288.45px] h-[61px] absolute left-0 top-0">
        <IC_stackoverflow />
      </div>
      <div className="flex justify-center items-center w-[288.45px] h-[102px] absolute left-0 top-[453.2px] p-4">
        <div className="flex-grow-0 flex-shrink-0 w-[261px] h-8">
          <p className="absolute left-[13.73px] top-[35px] text-[13px] text-center">
            <span className="text-[13px] text-center text-black">
              Don’t have an account?
            </span>
            <span className="text-[13px] text-center text-[#0075cf]">
              {' '}
              Sign up
            </span>
            <br />
            <span className="text-[13px] text-center text-black">
              Are you an employer?
            </span>
            <span className="text-[13px] text-center text-[#0075cf]">
              {' '}
              Sign up on Talent
            </span>
          </p>
          <IC_share className="absolute left-[255.23px] top-[57.5px]"/>
        </div>
      </div>
      <div className="flex flex-col justify-start items-start w-[288.45px] h-[158px] absolute left-[0.23px] top-[61px] gap-1 py-1">
        <div className="cursor-pointer flex justify-start items-center flex-grow-0 flex-shrink-0 w-[288.45px] h-[37.8px] gap-[7px] px-[82px] py-[9px] rounded-[5px] bg-white border-[0.5px] border-[#9fa6ad]">
          <IC_google />
          <p className="flex-grow-0 flex-shrink-0 text-[13px] font-medium text-center text-[#3b4045]">
            Log in with Google
          </p>
        </div>
        <div className="cursor-pointer flex justify-start items-center flex-grow-0 flex-shrink-0 w-[288.45px] h-[37.8px] gap-[7px] px-[82px] py-[9px] rounded-[5px] bg-[#fee500] border-[0.5px] border-[#9fa6ad]">
          <IC_kakao />
          <p className="flex-grow-0 flex-shrink-0 text-[13px] font-medium text-center text-[#3b4045]">
            Log in with KaKao
          </p>
        </div>
        <div className="cursor-pointer flex justify-start items-center flex-grow-0 flex-shrink-0 w-[288.45px] h-[37.8px] gap-[7px] px-[82px] py-[9px] rounded-[5px] bg-[#22c75a] border-[0.5px] border-[#9fa6ad]">
          <img
            src={ic_naver}
            className="flex-grow-0 flex-shrink-0 w-[18px] h-[16.2px] object-cover"
            alt=""
          />
          <p className="flex-grow-0 flex-shrink-0 text-[13px] font-medium text-center text-white">
            Log in with Naver
          </p>
        </div>
      </div>
      <div
        className="flex flex-col justify-start items-center w-[288.45px] h-[234.2px] absolute left-0 top-[219px] gap-1.5 p-6 rounded-[7px] bg-white"
        style={{ boxShadow: '2px 2px 4px 0 rgba(0,0,0,0.25)' }}
      >
        <div className="flex justify-start items-center flex-grow-0 flex-shrink-0 w-[240.45px] relative py-1.5">
          <p className="flex-grow-0 flex-shrink-0 text-[15px] font-semibold text-center text-black">
            Email
          </p>
        </div>
        <input className="flex-grow-0 flex-shrink-0 w-[240.45px] h-[32.59px] pl-2 relative rounded-[3px] bg-white border-[0.5px] border-[#9fa6ad]" />
        <div className="flex justify-between items-center flex-grow-0 flex-shrink-0 w-[240.45px] relative py-1.5">
          <p className="flex-grow-0 flex-shrink-0 text-[15px] font-semibold text-center text-black">
            Password
          </p>
          <p className="flex-grow-0 flex-shrink-0 text-xs text-center text-[#4285f4]">
            Forgot password?
          </p>
        </div>
        <input className="flex-grow-0 flex-shrink-0 w-[240.45px] h-[32.59px] pl-2 relative rounded-[3px] bg-white border-[0.5px] border-[#9fa6ad] " />
        <div className="cursor-pointer flex justify-center items-center flex-grow-0 flex-shrink-0 w-[240.45px] h-[37.8px] gap-2.5 p-2.5 rounded-[3px] bg-[#0a95ff] hover:bg-[#0074cc]">
          <p className="flex-grow-0 flex-shrink-0 w-[114px] text-[13px] font-medium text-center text-white">
            Log in
          </p>
        </div>
      </div>
    </div>
  );
};

export default Login;
