import './App.css';
import React , {useState} from 'react';
import Card from "./components/UI/Card/Card"

function App() {
  const [showQuestion ,setShowQuestions] = useState(false);
  const [questionsCorrect, setquestionsCorrect] = useState(0);
  const [showQuiz, setShowQuiz] = useState(false);
  
  function handleStartQuiz(){
    setShowQuestions(true);
  }
  const questions = [
    {
      quesId: 1,
      ques: 'What color is the sky?',
      Options: {
        option1: 'Blue',
        option2: 'Red',
        option3: 'Yellow',
        option4: 'Green',
      },
      answer: 'Blue',
    },
    {
      quesId: 2,
      ques: 'What color is are the leaves ?',
      Options: {
        option1: 'Blue',
        option2: 'Red',
        option3: 'Yellow',
        option4: 'Green',
      },
      answer: 'Green',
    },
    {
      quesId: 3,
      ques: 'What color is the sun?',
      Options: {
        option1: 'Blue',
        option2: 'Red',
        option3: 'Yellow',
        option4: 'Green',
      },
      answer: 'Yellow',
    },
  ]
  const handleCorrectAnswerMarkUpdate = (isCorrect) => {
    console.log(isCorrect);
    if(isCorrect){
      setquestionsCorrect(questionsCorrect + 1);
    }
  }
  const showResults = () => {
    console.log("Show Results", questionsCorrect);
    setShowQuiz(true);
  }
  return (
    <div className="App">
      <h1>Quizz App</h1>
      {
        !showQuestion ? 
        (
        <button className='Startbtn' onClick={handleStartQuiz}>Start Quiz</button>
        )
        :
        showQuiz===false?
        (
          <>
          <div className="container">
            {questions.map((item) => (
              <Card 
                key={item.quesId}
                question={item.ques}
                correctAnswerMarkUpdate={handleCorrectAnswerMarkUpdate}
                attempt={"ka"}
                options={item.Options}
                answer={item.answer}
              />
            ))}
          </div>
            <button onClick={showResults} className='ResultBtn'>Show Results</button>
          </>
        )
        :
        (
          <div className='ResultDiv'>
            <h1>You have answered {questionsCorrect} / {questions.length} Correctly</h1>
            <button onClick={handleStartQuiz}>Start Quiz</button>
          </div>
        )
      }
    </div>
  );
}

export default App;