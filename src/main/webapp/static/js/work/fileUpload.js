const fileUpload = {
      upload(files) {
            const formData = new FormData(); // POST, multipart
            for (const file of files) {
                formData.append("files", file);
            }
        // /works/add -> ../../file/upload
        const xhr = new XMLHttpRequest()
               xhr.open("POST", "../file/upload");
               xhr.send(formData);
      xhr.onreadystatechange = function() {
                  if (xhr.status == 200 && xhr.readyState == XMLHttpRequest.DONE) {
                      const res = xhr.responseText;
                      console.log(res);
                  }
       };
    }
};

window.addEventListener("DOMContentLoaded", function() {
    const fileUploads = document.getElementsByClassName("fileUpload");
    const fileEl = document.getElementById("file");

    for (const el of fileUploads) {
        el.addEventListener("click", function(){
            fileEl.click();
        });
    }

    // 파일 탐색기에서 파일 선택 : change 이벤트가 발생
    fileEl.addEventListener("change", function(e) {
            const files = e.target.files;
            fileUpload.upload(files);
    });
});