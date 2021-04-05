//const sceneNum = document.getElementById("SceneNumber");
var sceneNum = 0;
const clearSceneNum = 8;
const bossSceneNum = 7;
const imgs = [document.querySelector('.TitleScene'),
    document.querySelector('.FirstScene'),
    document.querySelector('.SecondScene'),
    document.querySelector('.ThirdScene'),
    document.querySelector('.FourthScene__bef'),
    document.querySelector('.FourthScene__aft'),
    document.querySelector('.FifthScene'),
    document.querySelector('.LastScene'),
    document.querySelector('.ClearScene')
];
const quest = document.querySelector('.Quest');
const efs = [document.getElementById('ef__fanfare'),
    document.getElementById('ef__magic')
];
const bgms =[document.getElementById('bgm__jungle'),
    document.getElementById('bgm__boss')
];

bgms[0].volume = 0.2;
bgms[1].volume = 0.2;
/* 노래 재생 안 되는지 확인하기 위한 코드 
let startPlayPromise = efs[0].play();

if (startPlayPromise !== undefined) {
  startPlayPromise.catch(error => {
    if (error.name === "NotAllowedError") {
      showPlayButton(efs[0]);
    } else {
      // Handle a load or playback error
    }
  }).then(() => {
    // Start whatever you need to do only after playback
    // has begun.
  });
}
출처 : https://developer.mozilla.org/ko/docs/Web/Media/Autoplay_guide*/

function CountScene(type) {
    //결과를 표시할 element
    //현재 화면에 표시된 값
    //let number = sceneNum.innerText;
    let number  = sceneNum;
    


    // 더하기 빼기

    if(type === "next")
    {
        if(sceneNum === clearSceneNum) return 8; // 마지막 장면 이후 x
        number = parseInt(number) + 1;
        
        MoveScene(number,"next");
        
    }
    else if(type === "previous")
    {
        if(number===0) return 0; // 타이틀 장면 이전 x
        if(number===1) {
            alert("늪에 빠져서 벗어날 수 없다...!");
            return 1;
        }
        number = parseInt(number) - 1;
        
        MoveScene(number,"previous");
    }
    //sceneNum.innerText = number;
    sceneNum = number;
    if(sceneNum === clearSceneNum)  GameClear();//클리어 장면
    if(sceneNum === 1) GameStart(); //시작 장면
    if(sceneNum === bossSceneNum) BossBattle(); //보스전
    
}

MoveScene = (scene_number, type_2) =>{
    
    if(type_2 === "next")
    {
        imgs[parseInt(scene_number)].classList.toggle('active');  //현재 장면 표시
        imgs[parseInt(scene_number)-1].classList.toggle('active'); // 이전 장면 삭제
    }
    else if(type_2 === "previous")
    {
        imgs[parseInt(scene_number)].classList.toggle('active');  //현재 장면 표시
        imgs[parseInt(scene_number)+1].classList.toggle('active'); // 이전 장면 삭제
    }
};
BossBattle = () =>{
    bgms[0].currentTime = 0;
    bgms[0].pause(); // main bgm off
    bgms[1].currentTime = 0;
    bgms[1].play(); // boss bgm on
    
}
GameStart = () =>{
    bgms[1].currentTime = 0;
    bgms[1].pause(); // boss bgm off
    bgms[0].currentTime = 0;
    bgms[0].play(); // main bgm on
}
GameClear = () =>{
    quest.classList.toggle('end');
    bgms[1].pause(); // bgm off
    bgms[0].pause();
    efs[0].play();

}
