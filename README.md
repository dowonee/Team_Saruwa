# ![header](https://capsule-render.vercel.app/api?type=waving&color=auto&height=300&section=header&text=SARUWA&fontSize=90)
---

<p align="center"><a href="https://imgbb.com/"><img src="https://i.ibb.co/874GsQr/4.jpg" alt="4" border="0"></a></p>

## ⚡ 프로젝트 계획
> 의류를 판매하는 종합 쇼핑몰로 상품 상세페이지, 장바구니를 통해 결제가 가능합니다.
> 조원들 모두가 구현할 수 있는 범위가 넓었고 가장 접근성이 좋았기 때문에 쇼핑몰을 선정해 프로젝트를 기획했습니다.


---      
</br>


## ⚡ 프로젝트 기간
> 2021.06.25 - 2021.07.08


---      
</br>



## ⚡개발환경
* System : Window 10
* Language : Java(JDK - 15), JSP, Html5, CSS, JS
* Tools : Github
* Development Tools : Eclipse IDE, eXERD
* DBMS : Oracle DB XE 11g
* WAS : Tomcat 9.0


---      
</br>



## ⚡ 맡은 기능구현

* 메인화면  

><a href="https://imgbb.com/"><img src="https://i.ibb.co/FDN5L98/18.png" alt="18" border="0"></a>

* 상품 리스트
><a href="https://imgbb.com/"><img src="https://i.ibb.co/KbcNrfR/19.png" alt="19" border="0"></a>
<a href="https://imgbb.com/"><img src="https://i.ibb.co/KjX5NND/21.png" alt="21" border="0"></a>


```
SELECT a.pname, pcode, pbrand,color,price,pdate,b.cnt FROM sproduct a,(SELECT cnt, pname FROM 
(SELECT sum(cnt) cnt, pname FROM sorder GROUP BY pname)) b WHERE a.pname = b.pname 
ORDER BY cnt desc
```

```
SELECT pcode, pname, pbrand, color, price, pdate FROM SPRODUCT WHERE pcode LIKE '%TP%' ORDER BY price
```

* 상품 상세페이지
><a href="https://ibb.co/30cVBD1"><img src="https://i.ibb.co/Wcf7gbn/20.png" alt="20" border="0"></a>

```
SELECT s.psize FROM sproduct p, stock s WHERE p.pcode = s.PCODE AND pname LIKE ?
```



### * Java로 기능 구현

* 상품 주문서

><a href="https://ibb.co/BZ0jgXT"><img src="https://i.ibb.co/zRqbSyP/22.png" alt="22" border="0"></a>

* 상세보기/옵션/비슷한 상품 리스트

><a href="https://ibb.co/wpfpqfH"><img src="https://i.ibb.co/0YxYLxN/23.png" alt="23" border="0"></a>

><a href="https://imgbb.com/"><img src="https://i.ibb.co/3hNdPWJ/24.png" alt="24" border="0"></a>

---      
</br>



## ⚡ ISSUES
<details markdown="1">
<summary>펼치기</summary>

<a href="https://ibb.co/vjP0J4B"><img src="https://i.ibb.co/bKBcr53/26.png" alt="26" border="0"></a>

</details>
