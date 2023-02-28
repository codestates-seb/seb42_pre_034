// import { doc } from "prettier";
import writing from "../assets/writing.png"
import Editor from "../components/Editor"
const Ask = () => {
    
    return (
        <div className="flex flex-col flex-nowrap my-8 mx-8 pr-2 flex-wrap max-w-screen-lg">
            <span className="text-4xl font-semibold my-8">Ask a public question</span>
            
            {/* Writing a good question */}
            <div className="bg-sky-100 border-2 my-4 px-8 py-4">
                <h3 className="text-3xl my-4">Writing a good question</h3>
                <p className="text-xl">You’re ready to <span className="text-sky-500">ask</span> a <span className="text-sky-500">programming-related question </span>and this form will help guide you through the process.</p>
                <p className="text-xl">Looking to ask a non-programming question? See <span className="text-sky-500">the topics here</span> to find a relevant site.</p>
                
                {/* Steps ~ */}
                <ul className="flex-nowrap my-4">
                    <p className="font-semibold text-2xl my-2">Steps</p>
                    <li className="mx-16 list-disc">Summarize your problem in a one-line title.</li>
                    <li className="mx-16 list-disc">Describe your problem in more detail.</li>
                    <li className="mx-16 list-disc">Describe what you tried and what you expected to happen.</li>
                    <li className="mx-16 list-disc">Add “tags” which help surface your question to members of the community.</li>
                    <li className="mx-16 list-disc">Review your question and post it to the site.</li>
                </ul>
            </div>
            
            {/* Title ~ */}
            <div className="border h-auto py-5 my-8 px-8">
                <span className="text-2xl font-semibold">Title</span><br/>
                <span className="text-lg">Be specific and imagine you’re asking a question to another person.</span><br/>
                <input className="w-11/12 my-8 border" type="text"  placeholder="e.g. Is there an R function for finding the index of an element in a vector?"></input><br/>                        
            </div>

            {/* Introduce the problem ~ */}            
            <div className="text-2xl border h-auto py-4">
                <span className="px-8">Introduce the problem</span>
            </div>                        
            <div className="text-xl border h-auto flex py-5 leading-10">
            <img src={writing} alt="" className="w-20 h-20 mx-4" />
            Explain how you encountered the problem you’re trying to solve, and any difficulties that have prevented you from solving it yourself.
            </div>

            {/* What are ~ */}
            <div className="border h-auto py-5 my-8 px-8">
                <span className="text-2xl font-semibold">What are the details of your problem?</span><br/>
                <span className="text-lg">Introduce the problem and expand on what you put in the title. Minimum 20 characters.</span><br/>                
                <Editor options={ {id:'name',init:'기본 텍스트',height:'500px'} }/>
                
            </div>

            {/* What did ~ */}
            <div className="border h-auto py-5 my-8 px-8">
                <span className="text-2xl font-semibold">What did you try and what were you expecting?</span><br/>
                <span className="text-lg">Describe what you tried, what you expected to happen, and what actually resulted. Minimum 20 characters.</span><br/>                
                <Editor options={ {id:'name2',init:'기본 텍스트',height:'500px'} }/>
                
            </div>
            
            {/* Tags ~ */}
            <div className="border h-auto py-5 my-4 px-8">
                <span className="text-2xl font-semibold">Tags</span><br/>
                <span className="text-lg">Add up to 5 tags to describe what your question is about. Start typing to see suggestions.</span><br/>
                <input className="w-11/12 my-8 border" type="text"  placeholder="e.g. Is there an R function for finding the index of an element in a vector?"></input><br/>                        
            </div>
            {/* 조건문 만들어서 input이 최소 글자수보다 작으면 Button이 비활성화되게 만들기*/}
            <button className="bg-sky-400 w-20 h-12 rounded-md text-white hover:bg-sky-600" type="submit">Next</button>
        </div>
    );  
};

export default Ask;