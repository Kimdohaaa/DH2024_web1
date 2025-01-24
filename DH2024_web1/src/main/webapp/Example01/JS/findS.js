// 매출 출력
const findAll = () => {
	let findSbody = document.querySelector("#findSbody");
	let html = ``;
	
	fetch("/DH2024_web1/example1/sales")
		.then(res => res.json())
		.then(data => {
			data.forEach(obj => {
				html += `<tr>
							<td>${obj.mno}</td>
							<td>${obj.mname}</td>
							<td>${obj.mgrade}</td>
							<td>${obj.total}</td>
						</tr>`
			})
			findSbody.innerHTML = html;
		})
}
findAll();