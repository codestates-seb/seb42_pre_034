function Questions() {
  const questions = [
    {
      title: "Dummy Question 1",
      body: "Dummy Question 1's body",
      vote: 1,
      answer: 3,
      view: 5,
      tag: ["dummy", "fake"]
    },
    {
      title: "How to write better code than ChatGPT",
      body: "I want to be a very valuable front-end engineer. How do you do that? I think about it. If I can write better code than ChatGPT, will I become a very valuable front-end engineer?",
      vote: -1,
      answer: 0,
      view: 2,
      tag: ["career", "chatgpt", "ai"]
    }
  ];
  return (
    <>
      <h1>All Questions</h1>
    </>
  )
}

export default Questions