import { createSlice,createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

const initialState = {
  user: null,
  loading: false,
  error: null,
};

export const authSlice = createSlice({
  name: 'auth',
  initialState,
  reducers: {
    loginStart: (state) => {
      state.loading = true;
      state.error = null;
    },
    loginSuccess: (state, action) => {
      state.loading = false;
      state.user = action.payload;
    },
    loginFail: (state, action) => {
      state.loading = false;
      state.error = action.payload;
    },
  },
});

export const { loginStart, loginSuccess, loginFail } = authSlice.actions;

export const loginWithNaver = createAsyncThunk(
  'auth/loginWithNaver',
  async (code) => {
    /* eslint-disable-next-line no-undef */
    const response = await axios.post(`${process.env.REACT_APP_SERVER_URL}/auth/naver`, { code });
    return response.data.accessToken;
  }
);

export const loginWithKakao = (kakaoAccessToken) => async (dispatch) => {
  dispatch(loginStart());
  try {
    const response = await axios.post('/api/login/kakao', { kakaoAccessToken });
    dispatch(loginSuccess(response.data));
  } catch (error) {
    dispatch(loginFail(error.message));
  }
};

export default authSlice.reducer;