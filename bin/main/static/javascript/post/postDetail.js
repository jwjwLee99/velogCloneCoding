$(() => {
    // 스크롤 메뉴
    let previousScroll = 0;
    let lsm = $(".likeAndShare");
    let rsm = $(".titleList");
    $(window).scroll(function() {
        let currentScroll = $(this).scrollTop();
        let scrollTop = $(window).scrollTop();
    
        if(currentScroll > 210){
            lsm.css("position", "fixed").css("top", "112px");
            rsm.css("position", "fixed").css("top", "112px");
        }else if(currentScroll == scrollTop){
            lsm.css("position", "").css("top", "");
            rsm.css("position", "").css("top", "");
        }
        
    })

    // 좌측 좋아요 , 로그인 되어있을때 활성
    let isLike = true;
    let likebtn = $(".likeBox");
    likebtn.click(()=> {
        if(isLike){
            likebtn.css({
                backgroundColor:"#12B886",
                color:"#fff"
            })
            likebtn.addClass("likeOn")
            likebtn.removeClass("hoverLSM")
            likeCnt(isLike); // true 카운트 증가
            isLike = false
        }else {
            likebtn.css({
                backgroundColor:"#FFFFFF",
                color:"#868E96"
            }).animate({
                transform : "scale(1.2)"
            }, 1000)
            likebtn.addClass("hoverLSM")
            likebtn.removeClass("likeOn")
            likeCnt(isLike); // false 카운트 감소
            isLike = true
        }
        
    })

    function likeCnt(bools) {
        let cnt = $(".likeCnt");
        
        // ajax 처리
        if(bools){
            // 카운트 증가
        }else {
            // 카운트 감소
        }
    }

    // 좌측 공유 텝
    let sharebtn = $(".shareIcon");
    let facebook = $(".etcbox1");
    let twitter = $(".etcbox2");
    let address = $(".etcbox3");
    let shareTag = $(".shareTag");
    sharebtn.click(function() {
        facebook.fadeIn(300).animate({
            top:"-52px",
            left:"65px",
        },300);
        twitter.fadeIn(300).animate({
            left:"90px"
        }, 300);
        address.fadeIn(300).animate({
            top:"52px",
            left:"65px"
        },300)
        sharebtn.toggleClass("checked");
        if(!sharebtn.hasClass("checked")){
            facebook.animate({
                top:"0px",
                left:"8px",
            },300).fadeOut(300);
            twitter.animate({
                left:"8px"
            }, 300).fadeOut(300);
            address.animate({
                top:"0px",
                left:"8px"
            },300).fadeOut(300);
            shareTag.removeClass("checked")
        }
    })
    shareTag.click(function(){
        facebook.animate({
            top:"0px",
            left:"8px",
        },300).fadeOut(300);
        twitter.animate({
            left:"8px"
        }, 300).fadeOut(300);
        address.animate({
            top:"0px",
            left:"8px"
        },300).fadeOut(300);
        sharebtn.removeClass("checked")
    })

    // 시리즈 보기, 숨기기
    let toggleBtn = $(".seriesToggle");
    let hideSeries = $(".hideSeries")
    let showSeries = $(".showSeries")
    let ol = $(".seriesInfo ol");
    toggleBtn.html(
        '<svg class="showAndHide" stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 24 24" height="1em" width="1em" xmlns="http://www.w3.org/2000/svg">'+
        '<path d="M7 10l5 5 5-5z"></path>' +
        '</svg>'+
        '목록 보기'
    )
    toggleBtn.click((e) => {
        ol.slideDown(100)
        showSeries.toggleClass("hideSeries")
        if(toggleBtn.hasClass("hideSeries")){
            toggleBtn.html(
                '<svg class="showAndHide" stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 24 24" height="1em" width="1em" xmlns="http://www.w3.org/2000/svg">'+
                '<path d="M7 14l5-5 5 5z"></path>' +
                '</svg>'+
                '숨기기'
            )
        }else {
            toggleBtn.html(
                '<svg class="showAndHide" stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 24 24" height="1em" width="1em" xmlns="http://www.w3.org/2000/svg">'+
                '<path d="M7 10l5 5 5-5z"></path>' +
                '</svg>'+
                '목록 보기'
            )
            ol.slideUp(100)
        }
    })


    // 글쓴이 이메일 hover
    $(".authorEmail").mouseover(function() {
        $('.emailHover').css("display", "flex")
    })
    $(".authorEmail").mouseout(function () {
        $('.emailHover').css("display", "none")
    })


    /*************
     * ***
     * 댓글 
     * 답글
     * 댓글 답글 토글 완료 답답글 아직 남음
     * 할거 ㅈㄴ 많음 - 백 작업할때 다시 하기
    */
    /* 댓글 */
    let replyCnt = 1; // db로 댓글 갯수 불러오기

    /*
        수정 및 삭제 : 로그인 세션 사용자 인덱스가 같을 경우 보이기
    */
    // 댓글 수정
    $(".replyUpdateBtn").click(function(){
        $(this).parents(".replyElement").find(".replyBody > div").addClass("dpNone")
        $(this).parents(".replyElement").find(".replyUpdate").removeClass("dpNone")
        $(this).parents(".replyElement").find(".replyUpdate > textarea").val($(this).parents(".replyElement").find(".replyDesc > p").text())
        $(this).addClass("dpNone")
    })
    // 댓글 수정 취소
    $(".upcancel").click(function() {
        $(this).parents(".replyElement").find(".replyBody > div").removeClass("dpNone")
        $(this).parents(".replyElement").find(".replyUpdate").addClass("dpNone")
        $(this).parents(".replyElement").find(".replyUpdateBtn").removeClass("dpNone")
    })
    // 댓글 수정 완료

    // 댓글 삭제 - this를 통한 인덱스 가져와서 삭제
    $(".replyDel").click(()=> {
        $(".modal").fadeIn(100)
        $(".replyRemove").fadeIn(100)
    })
    $(".delcancel").click(()=> {
        $(".modal").fadeOut(100)
        $(".replyRemove").fadeOut(100)
    })
    // 삭제 확인

    // 답글
    let rtrCnt = 0; // db로 댓글에 대한 답글 갯수 불러오기

    // 답글 없을 때 - 답글달기
    if(rtrCnt <= 0){
        $(".hideRtr").addClass("dpNone");
        $(".showRtr").addClass("dpNone");
        $(".rtrTextArea").css("display", "block")
        $(".rtr").css("display", "none")
    }else { // 답글이 있을 때 - 답글보기
        $(".hideRtr").addClass("dpNone");
        $(".writeRtr").addClass("dpNone");
        $(".rtrTextArea").css("display", "none");
        $(".rtr").css("display", "block")
    }
    $(".showRtr").on("click", function(){
        $(this).addClass("dpNone");
        $(this).nextAll('.hideRtr').removeClass("dpNone");
        $(this).nextAll(".rtrSection").slideDown(100);
    })
    $(".writeRtr").on("click", function(){
        $(this).nextAll(".hideRtr").removeClass("dpNone")
        $(this).addClass("dpNone")
        $(this).nextAll(".rtrSection").slideDown(100)
    })
    $(".hideRtr").on("click",function(){
        if(rtrCnt <= 0){
            $(this).prevAll(".writeRtr").removeClass("dpNone")
        }else{
            $(this).prevAll(".showRtr").removeClass("dpNone")
        }
        $(this).nextAll(".rtrSection").slideUp(100)
        $(this).addClass("dpNone")
    })

    // 답글쓰기 취소
    $(".closeBtn").click(function(){
        $(this).parents(".replyToReply").find(".writeRtr").removeClass("dpNone")
        $(this).parents(".replyToReply").find(".rtrSection").slideUp(100)
        $(this).parents(".replyToReply").find(".hideRtr").addClass("dpNone")
    })

})