// 페이지 로드가 완료된 후 실행될 함수
window.onload = function() {
    // 라디오 버튼들을 가져와서 이벤트 리스너를 등록합니다.
    var radioButtons = document.querySelectorAll('input[name="category"]');
    
    // 각 라디오 버튼에 대해 이벤트 리스너를 등록합니다.
    radioButtons.forEach(function(radioButton) {
        radioButton.addEventListener('click', function() {
            // 선택된 라디오 버튼의 값을 가져옵니다.
            var selectedCategory = radioButton.value;
            
            // 선택된 카테고리에 대한 처리 수행
            // 예: 선택된 카테고리에 해당하는 도서 목록을 서버에 요청하거나 특정 동작 수행
            console.log('Selected category:', selectedCategory);
        });
    });
};
