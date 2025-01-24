// 회원 전체 출력
const findAll = () => {
	let findMbody = document.querySelector("#findMbody")
	let html = ``;
	
	fetch("/DH2024_web1/example1/member")
		.then(res => res.json())
		.then(data => {
			data.forEach(obj => {
				html += `<tr>
							<td> <a href="../JSP/changeM.jsp?mno=${obj.mno}"> ${obj.mno} </a></td>
							<td> ${obj.mname} </td>
							<td> ${obj.mphone} </td>
							<td> ${obj.maddr} </td>
							<td> ${obj.mdate} </td>
							<td> ${obj.mgrade} </td>
							<td> ${obj.mcity} </td>
						</tr> `
			})
			findMbody.innerHTML = html;
		})
}
findAll();


