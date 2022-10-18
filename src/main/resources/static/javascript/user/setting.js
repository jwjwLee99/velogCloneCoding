$(() => {
  //회원 탈퇴 버튼 변수
  let secessionback = $(".secessionBground")
  let secessionBtn = $(".secessionBtn")
  let secessionblank = $(".secession-area")
  let cancelBtn = $(".cancel")

  // 회원탈퇴 버튼 누를 시
  secessionBtn.click(() => {
    secessionback.css("display", "flex")
    secessionblank.css("display", "flex")
  })

  //회원탈퇴 취소 누를 시
  cancelBtn.click(() => {
    secessionback.css("display", "none")
    secessionblank.css("display", "none")
  })

  //알람 
  let isReplyAgree = true;
  let isUpdateAgree = true;

  // 댓글알람 버튼
  $(".replyAlarm").click(function () {
    if (isReplyAgree) {
      $(this).css({
        background: "#12B886"
      });
      $(this).children(".circle").animate({
        left: "1.325rem"
      }, 100)
      isReplyAgree = false
    } else {
      $(this).css({
        background: "rgb(134, 142, 150)"
      });
      $(this).children(".circle").animate({
        left: "0"
      }, 100)
      isReplyAgree = true
    }
  })

  // 업데이트알림 버튼
  $(".updateAlarm").click(function () {
    if (isUpdateAgree) {
      $(this).css({
        background: "#12B886"
      });
      $(this).children(".circle").animate({
        left: "1.325rem"
      }, 100)
      isUpdateAgree = false
    } else {
      $(this).css({
        background: "rgb(134, 142, 150)"
      });
      $(this).children(".circle").animate({
        left: "0"
      }, 100)
      isUpdateAgree = true
    }
  })

  //이름, 한줄소개 수정
  let correctionBtn = $(".profile-correction")
  let userInfo = $(".user-info")
  let correctionInfo = $(".correction-info")
  let saveInfo = $(".s1")

  correctionBtn.click(() => {
    userInfo.css("display", "none")

    correctionInfo.css("display", "flex")
    correctionInfo.css("flex-direction", "column")

  })
  saveInfo.click(() => {
    correctionInfo.css("display", "none")

    userInfo.css("display", "flex")
    userInfo.css("flex-direction", "column")
    userInfo.css("align-items", "flex-start")
  })


  //벨로그 제목 수정
  let tittleBtn = $(".correctionBtn")
  let pasiveT = $(".passive")
  let activeT = $(".active")
  let saveT = $(".s2")

  tittleBtn.click(() => {
    pasiveT.css("display", "none")

    activeT.css("display", "flex")
    activeT.css("flex-direction", "column")

  })

  saveT.click(() => {
    activeT.css("display", "none")

    pasiveT.css("display", "flex")
  })

  //소셜 추가
  let addSocial = $(".add-infoBtn")
  let addAddress = $(".add-address")
  let saveS = $(".s3")

  addSocial.click(() => {
    addSocial.css("display", "none")

    addAddress.css("display", "flex")
    addAddress.css("flex-direction", "column")
  })

  saveS.click(() => {
    addAddress.css("display", "none")

    addSocial.css("display", "flex")
  })

  //파일업로드
  let browseBtn = document.querySelector('.image-upload');
  let realInput = document.querySelector('#real-input');

  browseBtn.addEventListener('click', () => {
    realInput.click();
  });

  let reader = new FileReader();

  reader.onload = (readerEvent) => {
    document.querySelector("#imagePreview").setAttribute("src", readerEvent.target.result);
    //파일을 읽는 이벤트가 발생하면 img_section의 src 속성을 readerEvent의 결과물로 대체함
  };

  document.querySelector("#real-input").addEventListener("change", (changeEvent) => {
    //upload_file 에 이벤트리스너를 장착

    let imgFile = changeEvent.target.files[0];
    reader.readAsDataURL(imgFile);

  })

  //파일 삭제 

  $(".image-delete").click(function () {
    document.getElementById("imagePreview").src = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIAAAACACAYAAADDPmHLAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAASbSURBVHgB7Z0tTytBFIYP914BDiQ4cIADB0EhwYFE8ifq7g/hJ2CRSCQ4kOCobF3ruHk3maS5aSnbdnfPOe/7JE0oCTvTnmc+dvbMsNbr9b5M0PLLBDUSgBwJQI4EIEcCkCMByJEA5EgAciQAORKAHAlAjgQgRwKQIwHIkQDkSAByJAA5EoAcCUCOBCBHApAjAciRAORIAHIkADkSgBwJQI4EIEcCkCMByJEA5EgAciQAOX+MhPX1dTs+Prbt7W3b3d21jY2N6ndgPB7bYDCw4XBor6+v9vHxUb1nIL0Ae3t7dn5+XgV9FhABYuC1v79f/Q4SPD8/28vLi2UmrQA/Cfx34O/wwjXu7u7S9gi/z87O/loyELTr62vb2tqyZcFQcXp6Wv2MXiEb6SaBCDwEWDVFqmykEgABOjo6sqbAtbNJkEaAi4uLRoNfQBmXl5eWhRQCIChlnG6Dk5OTVstrkvACYKLXxJg/D5RZ1hEiE14ABGIVs/26IPgZeoHQAiDwbYz7s4AA0XuB0AIsusizKsrycmRCC+Dhyz84OLDIhBUAra/rHgCgDpGHgbAC7OzsmBc81aUuYQXY3Nw0L3iqS13CCtDFrd8sPNWlLsoIIkcCkBNWAE8JGpGTRcIKgPw9L3iqS13CCvD5+Wle8FSXuoQVAJm8HlK0UAfUJSqhJ4Fvb2/WNcgcjkxoAfDld936oieKhhYAwX96erKuwJ6B6Oni4dcBIEAXvQAC//j4aNEJLwCC30UgUGaGzSIpVgLRC7Q5FKCsLFvG0iwFPzw8tBIUlIGyspDqWcD9/X2jEuDaKCMT6R4GIUBNzAlwzWzBByl3ByNYaK23t7dLP6vHfT6u9/7+bhlZ6/V6X5YYpI0jebRu/mD2wBfSHxCBngAv9ASQ4PDwsErhwvvJE0JGo1EV9H6/72KFsS1SCDAZyFngnh2vVUwSUV4WQUILULZnlR06aMGYqDW1QDN56khZho6+Ghh2DoBgXF1dTZ3koZWvcqWubECdtg0NZUQ+QiakAGjxOA9gHhABj4wXeWyMHgX5/j85Zwi9AXoeD4+n6xJOAASk7nbwkjyCGT0meXg/mcWDYOMsIJwShtaO3mWRHT/odaINCaHmAIsEHyCQOP6tHAHXFKVukSQIsxK4aPDbBnWMdG5ACAHwhUYIfgHzEwwjEXAvQFdHwCzLzc1NiC1jrgXA2I31/Ijbr1HnCEfKuRagq/N/VgXuJLzPB9wKgMBnOITJu8RuBUDXnwHvQ4FLAbDkGrnr/x8MBV7vClwKEHHWPw+vn8mdANlaf8FrL+BOgIytv+Dxs7kSAC0kY+sveOwFXAnQ5bGvbdH0A6m6uBLAw8GPTePtaFk3AmTv/gtYF/A0DLgRgKH1Fzx9VjcCIBuHBU89nRsBkKrFgqfNJm5SwpBGVc7fz/CvWKZRUsk9bS1PvzVMfI+OiiVHApAjAciRAORIAHIkADkSgBwJQI4EIEcCkCMByJEA5EgAciQAORKAHAlAjgQgRwKQIwHIkQDkSAByJAA5EoAcCUCOBCBHApAjAciRAORIAHIkADkSgBwJQI4EIOcfGjV2tEfztqEAAAAASUVORK5CYII=";
  })


})

