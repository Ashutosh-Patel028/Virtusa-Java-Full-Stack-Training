import React, { useState } from "react";
import "./Card.css";

const Card = (props) => {
  const [isDisabled, setDisabled] = useState(false);
  const [questionsAnswered, setQuestionsAnswered] = useState(0);
  const [showResults, setShowResults] = useState(false);

  function handleQuestionAnswered() {
      setQuestionsAnswered(questionsAnswered + 1);
  }

  function handleShowResults() {
      setShowResults(true);
  }

  const optionClickHandler = (answer) => {
    setDisabled(true);
    if (answer === props.answer) {
      props.correctAnswerMarkUpdate(true);
    }
    else{
      props.correctAnswerMarkUpdate(false);
    }
  };

  return (
    <div className="container-2">
      <h4 className="quesClass">{props.question}</h4>
      <div >
        {Object.keys(props.options).map((key) => (
          <button
            key={key}
            disabled={isDisabled}
            onClick={() => optionClickHandler(props.options[key])}
            className="OptionBtn"
          >
            {props.options[key]}
          </button>
        ))}
      </div>
    </div>
  );
};

export default Card;