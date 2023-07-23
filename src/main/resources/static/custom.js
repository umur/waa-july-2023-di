window.onload = function () {
    /*************************
     preloader
     *************************/
    $("#load").fadeOut();
    $('#loading').delay(0).fadeOut('slow');


    document.getElementById("saveCourse").onclick = function () {
        event.preventDefault();
        const courseId = document.getElementById("courseId").value;
        const courseName = document.getElementById("courseName").value;
        const courseCode = document.getElementById("courseCode").value;
        const course = {
            id: courseId,
            name: courseName,
            code: courseCode
        };

        if (!courseId || !courseName || !courseCode) {
            document.getElementById('formmessage').innerHTML = 'Please fill all the boxes:';
        } else {
            fetch('/courses', {
                method: "POST",
                body: JSON.stringify(course),
                headers: {
                    "Content-type": "application/json; charset=UTF-8",
                },
            })
                .then(response => {
                    console.log('Data sent successfuly');
                }).catch(error => {
                console.error('Error', error);
            });
        }
    }
}