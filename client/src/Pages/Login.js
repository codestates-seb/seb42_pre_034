import { useState } from 'react';
import { ReactComponent as IC_LOGIN_STACKOVERFLOW } from '../assets/ic_login_stackoverflow.svg';
import { ReactComponent as IC_LOGIN_SHARE } from '../assets/ic_login_share.svg';
import { LOGIN_MESSAGES } from '../constants/constants';
import GoogleLoginButton from '../components/GoogleLoginButton';
import KakaoLoginButton from '../components/KakaoLoginButton';
import NaverLoginButton from '../components/NaverLoginButton'
import axios from 'axios';

const Login = () => {
  const [id, setId] = useState('');
  const [password, setPassword] = useState('');
  const [message, setMessage] = useState({
    id: '',
    password: ''
  });

    /** checkValid
   * - email 유효성 검사
   * - password 유효성 검사
   *    1. 최소 8자 이상의 30자 이하의 길이
   *    2. 영문 대/소문자 및 숫자가 최소 1개 이상 포함되어야 함
   *    3. 특수문자 [$@$!%*#?&]
   */
  function checkValid() {
    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,30}$/;

    if(id === '') {
      setMessage({id: LOGIN_MESSAGES.EMPTY_EMAIL, password: ''})
      return false
    }
    if(!emailRegex.test(id)) {
      setMessage({id: LOGIN_MESSAGES.VALID_EMAIL, password: ''})
      return false
    }
    if(password === '') {
      setMessage({id: '', password: LOGIN_MESSAGES.EMPTY_PASSWORD})
      return false
    }
    if(!passwordRegex.test(password)) {
      setMessage({id: '', password: LOGIN_MESSAGES.VALID_PASSWORD})
      return false
    }
    else return true
  }

  function handleLogin(e) {
    e.preventDefault();
    sessionLogin(id,password)
  }

const sessionLogin = (id, password) => {
  setMessage({id: '', password: ''})
  // eslint-disable-next-line no-undef
  if (checkValid()) return axios.post(`${process.env.REACT_APP_SERVER_URL}/sessionLogin`, {
    id: id,
    password: password
  },
  { withCredentials: true }
  )
  .then(response => {
    // 로그인 성공 시 처리할 로직
    window.location.href = response.data.redirectUrl;
  })
  .catch(error => {
    // 로그인 실패 시 처리할 로직
    console.log(error)
  });
};

  return (
    <div className='bg-[#f1f2f3] w-[100%] h-[100%] flex justify-center items-start pt-[120px]'>
    <div className="w-[288.45px] h-[555.2px] relative flex flex-col select-none">
      <div className="flex justify-center items-start w-[288.45px] h-[61px] left-0 top-0">
        <IC_LOGIN_STACKOVERFLOW />
      </div>
      <div className="flex flex-col justify-start items-start w-[288.45px] h-[158px] left-[0.23px] top-[61px] gap-1 py-1">
        <GoogleLoginButton />
        <KakaoLoginButton />
        <NaverLoginButton />
      </div>

      <form
        className="flex flex-col  justify-start items-start w-[288.45px] left-0 top-[219px] gap-1.5 p-6 mb-[24px] rounded-[7px] bg-white"
        style={{ boxShadow: '2px 2px 4px 0 rgba(0,0,0,0.25)' }}
        onSubmit={handleLogin}
      >
        <div className="flex justify-start items-center flex-grow-0 flex-shrink-0 w-[240.45px] relative py-1.5">
          <p className="flex-grow-0 flex-shrink-0 text-[15px] font-semibold text-center text-black">
            Email
          </p>
        </div>
        <input
          className="flex-grow-0 flex-shrink-0 w-[240.45px] h-[32.59px] pl-2 relative rounded-[3px] bg-white border-[0.5px] border-[#9fa6ad]"
          type="text"
          value={id}
          onChange={(e) => setId(e.target.value)}
        />
        <p
          className={`${message.id === '' ?'hidden':''} pl-2 text-xs text-left text-[#D03932]`}
        >
          {message.id}
        </p>
        <div className="flex justify-between items-center flex-grow-0 flex-shrink-0 w-[240.45px] relative py-1.5">
          <p className="flex-grow-0 flex-shrink-0 text-[15px] font-semibold text-center text-black">
            Password
          </p>
          <p className="flex-grow-0 flex-shrink-0 text-xs text-center text-[#4285f4]">
            Forgot password?
          </p>
        </div>
        <input
          className="flex-grow-0 flex-shrink-0 w-[240.45px] h-[32.59px] pl-2 relative rounded-[3px] bg-white border-[0.5px] border-[#9fa6ad] "
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <p
          className={`${message.password === ''?'hidden':''} pl-2 text-xs text-left text-[#D03932]`}
        >
          {message.password}
        </p>
        <button
          type="submit"
          className="cursor-pointer flex justify-center items-center flex-grow-0 flex-shrink-0 w-[240.45px] h-[37.8px] gap-2.5 p-2.5 rounded-[3px] bg-[#0a95ff] hover:bg-[#0074cc]"
        >
          <p className="flex-grow-0 flex-shrink-0 w-[114px] text-[13px] font-medium text-center text-white">
            Log in
          </p>
        </button>
      </form>
      <div className="flex flex-col justify-center item-center mt-[24px]">
        <div className="flex flex-row justify-center items-end gap-1">
          <span className="text-[13px] text-center text-black">
            Don’t have an account?
          </span>
          <span className="text-[13px] text-center text-[#0075cf]">
            Sign up
          </span>
        </div>
        <div className="flex flex-row justify-center items-end gap-1">
          <span className="text-[13px] text-center text-black whitespace-nowrap">
            Are you an employer?
          </span>
          <span className="text-[13px] text-center text-[#0075cf] whitespace-nowrap">
            Sign up on Talent
          </span>
          <IC_LOGIN_SHARE className="" />
        </div>
      </div>
    </div>
    </div>
  );
};

export default Login;
