/* eslint-disable */
import userImg from '../assets/user_img.png';
import { useState,useEffect,useRef } from 'react';
import { Link } from 'react-router-dom';
import { ReactComponent as IC_HEADER_STACKOVERFLOW } from '../assets/ic_header_stackoverflow.svg';
import { ReactComponent as IC_HEADER_HELP } from '../assets/ic_header_help.svg';
import { ReactComponent as IC_HEADER_STACKEXCHANGE } from '../assets/ic_header_stackexchange.svg';
import { ReactComponent as IC_HEADER_INBOX } from '../assets/ic_header_inbox.svg';
import { ReactComponent as IC_HEADER_ACHIEVEMENTS } from '../assets/ic_header_achievements.svg';
import { ReactComponent as IC_HEADER_SEARCH } from '../assets/ic_header_search.svg';


function Header() {
  const [token, setToken] = useState(false);
  const hideRef = useRef([]);
  const searchRef = useRef(null);

  useEffect(() => {
    const isLogOn = token?'none':'flex';
    const isLogOut = token?'flex':'none';

    hideRef.current[0].style.display = isLogOut
    hideRef.current[2].style.display = isLogOut
    hideRef.current[3].style.display = isLogOn
    hideRef.current[4].style.display = isLogOn
    hideRef.current[5].style.display = isLogOn
    hideRef.current[6].style.display = isLogOn
    hideRef.current[7].style.display = isLogOn
    hideRef.current[8].style.display = isLogOut
    hideRef.current[9].style.display = isLogOut
    searchRef.current.style.width = token?'773.39px':'704.39px'
  }, [token])

  return (
    <>
      <div
        className="flex justify-center items-center pl-[36px] w-[100%] h-[50px] bg-[#f8f8f9] border-t-2 border-r-0 border-b-0 border-l-0 border-[#601bb3]"
        style={{ boxShadow: '0px 1px 4px 0 rgba(0,0,0,0.25)' }}
      >
        <div className="flex justify-center items-center">
        <Link to={'/'} className='flex justify-center items-center h-[47px] w-[166px] px-[8px] pb-1 hover:bg-[#E3E6E8]'><IC_HEADER_STACKOVERFLOW className=''/></Link>
          <button ref={(ref) => hideRef.current[0] = ref} className="header_left_btn"><p className="header_left_btn_font">About</p></button>
          <button ref={(ref) => hideRef.current[1] = ref} onClick={() => setToken(!token)} className="header_left_btn"><p className="header_left_btn_font">Products</p></button>
          <button ref={(ref) => hideRef.current[2] = ref} className="header_left_btn"><p className="header_left_btn_font">For Teams</p></button>
          <div className='relative flex items-center'>
          <IC_HEADER_SEARCH className='absolute w-[32px] left-[8px] cursor-text' />
          <input ref={searchRef} 
          className='placeholder:italic placeholder:text-slate-400 placeholder:text-sm flex justify-start items-center h-[32.59px] pl-[40px] mr-[8px] py-[7px] rounded-[3px] bg-white border-[0.5px] border-[#babfc4]' 
          placeholder="Search for anything..." 
          type="text" 
          name="search"/>
          </div>
          <button ref={(ref) => hideRef.current[3] = ref} className='header_user_btn'><img src={userImg} className='w-[24px]'/>1</button>
          <button ref={(ref) => hideRef.current[4] = ref} className='header_right_btn'><IC_HEADER_INBOX /></button>
          <button ref={(ref) => hideRef.current[5] = ref} className='header_right_btn'><IC_HEADER_ACHIEVEMENTS /></button>
          <button ref={(ref) => hideRef.current[6] = ref} className='header_right_btn'><IC_HEADER_HELP /></button>
          <button ref={(ref) => hideRef.current[7] = ref} className='header_right_btn'><IC_HEADER_STACKEXCHANGE /></button>
        <button ref={(ref) => hideRef.current[8] = ref}
        className="flex justify-center items-center w-[59.46px] h-[33px] px-2.5 py-3.5 rounded-[3px] bg-[#e1ecf4] border-[0.5px] border-[#7aa7c7]" >
          <p className="header_login_font text-[#39739d]">Log in</p>
        </button>
        <button ref={(ref) => hideRef.current[9] = ref}
        className="flex justify-center items-center w-[68.45px] h-[33px] ml-[4px] px-[11px] py-3.5 rounded-[3px] bg-[#0a95ff] border-[0.5px] border-[#349eef]">
          <p className="header_login_font text-white">Sign up</p>
        </button>

      </div>
        </div>
    </>
  );
}
export default Header;
