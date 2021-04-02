//const sceneNum = document.getElementById("SceneNumber");
var sceneNum = 0;
const imgs = [document.querySelector('.MainScene'),
document.querySelector('.FirstScene'),
document.querySelector('.SecondScene'),
document.querySelector('.ThirdScene'),
document.querySelector('.FourthScene'),
document.querySelector('.FourthScene2'),
document.querySelector('.FifthScene'),
document.querySelector('.LastScene')
];


ChangeScene = (scene_number, type_2) =>{
    if(type_2 === "next")
    {
        imgs[parseInt(scene_number)].classList.toggle('active');  
        imgs[parseInt(scene_number)-1].classList.toggle('active');
    }
    else if(type_2 === "previous")
    {
        imgs[parseInt(scene_number)].classList.toggle('active');  
        imgs[parseInt(scene_number)+1].classList.toggle('active');
    }
};

function CountScene(type) {
    //결과를 표시할 element


    //현재 화면에 표시된 값
    //let number = sceneNum.innerText;
    let number  = sceneNum;

    // 더하기 빼기

    if(type === "next")
    {
        if(number ==="7") { return 7;} // 7번째 장면 이후 x
        number = parseInt(number) + 1;
        
        ChangeScene(number,"next");
        
    }
    else if(type === "previous")
    {
        if(number==="0"){ return 0;} // 첫번째 장면 이전 x
        number = parseInt(number) - 1;
        
        ChangeScene(number,"previous");
    }
    //sceneNum.innerText = number;
    sceneNum = number;
}
