function CountScene(type) {
    //결과를 표시할 element
    const resultElement = document.getElementById("SceneNumber");

    //현재 화면에 표시된 값
    let number = resultElement.innerText;

    // 더하기 빼기

    if(type === "plus")
        number = parseInt(number) + 1;
    else if(type === "minus")
        number = parseInt(number) - 1;

    resultElement.innerText = number;
}