import { useState } from 'react';
import ic_earth from '../assets/ic_earth.svg';
// import { Link } from 'react-router-dom';

function MenuItem({ label, selectMenu, isSelected }) {
  // label: 메뉴 아이템으로 표시할 텍스트
    // label이 'Questions'일 경우 지구 아이콘을 앞에 붙임
  // selectMenu: 메뉴 아이템 클릭 시 수행할 이벤트 핸들러
    // 다음과 같은 동작 수행
    // 1. Click된 탭의 상태를 true로 변경
    // 2. 해당 경로로 링크 이동
  // isSelected: 해당 탭이 선택된 탭인지 표시
  
//   <div class="flex">
//   <img src="image.png" class="w-1/3">
//   <p class="ml-4">Your text here</p>
// </div>

  return (
    <>
      <li
        className={`
          w-[164px] h-[34px] flex flex-wrap flex items-center
          ${
            // 선택된 탭일 경우 메뉴 아이템의 배경색을 변경
            isSelected ? 'bg-[#f1f2f3]' : 'bg-white'
          }
        `}
        // li는 non-interactive한 요소이므로 이벤트 핸들러를 부여하려면 interative하게 바꿔주는 role을 부여
        // ref: https://github.com/jsx-eslint/eslint-plugin-jsx-a11y/blob/93f78856655696a55309440593e0948c6fb96134/docs/rules/no-noninteractive-element-interactions.md
        role="menuitem"
        onClick={selectMenu}
        // non-interactive 요소에 onClick만 부여할 수 없으며, 키보드로도 동작할 수 있게 해야함
        // https://github.com/jsx-eslint/eslint-plugin-jsx-a11y/blob/93f78856655696a55309440593e0948c6fb96134/docs/rules/click-events-have-key-events.md
        onKeyUp={(e) => {
          if (e.key === 'Enter') selectMenu();
        }}
      >
        {(label === 'Questions') ? <img src={ic_earth} alt='Earth icon' /> : ''}
        <p className='text-[13px] text-left text-[#525960]'>
          {label}
        </p>
      </li>
    </>
  )
}

function Menu() {
  // 초기 값은 Questions 메뉴가 선택된 상태
  const [isSelected, setIsSelected] = useState('Questions');

  // 클릭 시 수행할 이벤트 핸들러
  const selectMenu = (e) => {
    const selectedMenu = e.target.textContent;
    // 다음과 같은 동작 수행
    // 1. Click된 탭의 상태를 true로 변경
    setIsSelected(selectedMenu);
    // 2. 해당 경로로 링크 이동
    location.replace(`/seb42_pre_034/${selectedMenu}`);
  };

  return (
    <>
      <ul>
        <MenuItem
          label="Questions"
          selectMenu={selectMenu}
          isSelected={isSelected}
        />
        <MenuItem
          label="test"
          selectMenu={selectMenu}
          isSelected={isSelected}
        />
      </ul>
    </>
  );
}

export default Menu;