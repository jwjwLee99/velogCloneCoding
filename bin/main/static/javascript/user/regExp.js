$(function (){
    const userid = $('#userid');
    const userpw = $('#userpw');
    const userpw_re = $('#userpwcheck');
    const name = $('#username');
    const hp = $('#userpnum');
    const email = $('#useremail');
    const isIdCheck = $('#isidCheck');
    const isPWCheck = $('#ispwCheck')

    const expIdText = /^[a-z]+[a-z0-9]{5,19}$/g;
    const expPWText = /(?=.*\d{1,})(?=.*[~`!@#$%\^&*()-+=]{1,})(?=.*[a-zA-Z]{2,}).{8,16}$/;
    const expNumberText = /^[0-9]+$/;
    const expNameText = /[가-힣]+$/;
    const expHpText = /^\d{3}-\d{3,4}-\d{4}$/;
    const expEmailText = /^[A-Za-z0-9\-\.]+@[A-Za-z0-9\-\.]+\.[A-Za-z0-9]+$/; 


    // 입력시 이벤트
    userid.change(function(){
        console.log(this.value)
        if(this.value.length < 4){ // 아이디 길이
            $(".isId").html("4자이상").css("color","red")
        }else if(this.value.length > 20){
            $(".isId").html("20자이하").css("color","red")
        }else if(this.value == expNameText){ // 정규식
            $(".isId").html("한글금지").css("color","red")
        }
        else {
            $(".isId").html("사용가능").css("color", "#12B886")
            isIdCheck.value = 'y'
        }
        // 아이디 중복 검사 추가 필요
    })
    userpw.change(function(){
        let pwcValue;
        userpw_re.each(function(){
            pwcValue = this.value;
        })
        $(".isPWC").html("불일치").css("color", "red")
        isPWCheck.value = 'n';
        console.log(this.value)
        if(this.value.length < 8){
            $(".isPW").html("8자이상").css("color", "red")
            isPWCheck.value = 'n'
        }else if(this.value.length > 16){
            $(".isPW").html("16자이하").css("color", "red")
            isPWCheck.value = 'n'
        }else if(!expPWText.test(this.value)){
            $(".isPW").html("영문+숫자+특수문자").css("color", "red")
            isPWCheck.value = 'n'
        }else{
            $(".isPW").html("사용가능").css("color", "#12B886")
            isPWCheck.value = 'y'
        }
    })
    userpw_re.change(function(){
        let pwCheck2;
        userpw.each(function(){
            pwCheck2 = this.value;
        })
        if(pwCheck2 != this.value){
            $(".isPWC").html("불일치").css("color", "red")
            isPWCheck.value = 'n'
        }else{
            $(".isPWC").html("일치").css("color", "#12B886")
            isPWCheck.value = 'y'
        }
    })
    $(".accountSubmit").click(function(){
        if(sendit()){
            console.log(true)
            $(".background").fadeIn(500)
        }
    })
    $(".modalCancel").click(function(){
        $(".background").fadeOut(500)
    })
})
function sendit() {
    const userid = document.getElementById("userid");
    const userpw = document.getElementById('userpw');
    const userpw_re = document.getElementById('userpwcheck');
    const name = document.getElementById('username');
    const hp = document.getElementById('userpnum');
    const email = document.getElementById('useremail');
    const isIdCheck = document.getElementById('isidCheck');
    const isPWCheck = document.getElementById('ispwCheck');

    const expIdText = /^[a-z]+[a-z0-9]{5,19}$/g;
    const expPWText = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/;
    const expNumberText = /^[0-9]+$/;
    const expNameText = /[가-힣]+$/;
    const expHpText = /^\d{3}-\d{3,4}-\d{4}$/;
    const expEmailText = /^[A-Za-z0-9\-\.]+@[A-Za-z0-9\-\.]+\.[A-Za-z0-9]+$/; 

    // id
    if(userid.value == ''){
        alert('아이디를 입력하세요');
        $(window).scrollTop(0);
        userid.focus();
        return false;
    }else {
        isIdCheck.value = 'y';
    }

    // password
    if(userpw.value == ''){
        alert('비밀번호를 입력하세요');
        userpw.focus();
        return false;
    }else {
        isPWCheck.value = 'y'
    }

    // phone number
    if(!expHpText.test(hp.value)){
        alert('휴대폰번호 형식을 확인하세요\nex)000-0000-0000')
        hp.focus();
        return false;
    }

    // email
    if(!expEmailText.test(email.value)){
        alert('이메일 형식을 확인하세요\nex)OOO@OOO.OOO');
        email.focus();
        return false;
    }

    // join success
    if(isIdCheck.value == 'y' && isPWCheck.value == 'y'){
        return true;
    }
}