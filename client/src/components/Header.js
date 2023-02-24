/* eslint-disable */
import userImg from '../assets/user_img.png';
import { useState } from 'react';
import { Link } from 'react-router-dom';
import { ReactComponent as IC_HEADER_STACKOVERFLOW } from '../assets/ic_header_stackoverflow.svg';
import { ReactComponent as IC_HEADER_HELP } from '../assets/ic_header_help.svg';
import { ReactComponent as IC_HEADER_STACKEXCHANGE } from '../assets/ic_header_stackexchange.svg';
import { ReactComponent as IC_HEADER_INBOX } from '../assets/ic_header_inbox.svg';
import { ReactComponent as IC_HEADER_ACHIEVEMENTS } from '../assets/ic_header_achievements.svg';

function Header() {
  const [token, setToken] = useState(false);

  return (
    <>
      <div
        className="flex justify-center items-center w-[100%] h-[50px] relative gap-2.5 bg-[#f8f8f9] border-t-2 border-r-0 border-b-0 border-l-0 border-[#601bb3]"
        style={{ boxShadow: '0px 1px 4px 0 rgba(0,0,0,0.25)' }}
      >
        <IC_HEADER_STACKOVERFLOW onClick={() => alert('hi')}/>
        <IC_HEADER_INBOX />
        <IC_HEADER_ACHIEVEMENTS />
        <IC_HEADER_HELP />
        <IC_HEADER_STACKEXCHANGE />
      </div>
    </>
  );
}
export default Header;
