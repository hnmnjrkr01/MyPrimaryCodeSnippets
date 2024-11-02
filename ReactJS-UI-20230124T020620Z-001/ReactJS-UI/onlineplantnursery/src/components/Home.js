import React from "react";
import "./Home.css";

export default function Home() {
  return <div className="Homebody">
    <div className="Banner1">

      {/* <img src="https://floweraura-blog-img.s3.ap-south-1.amazonaws.com/Plant+Dec+2019-+Dec+2020/basic-information-about-plants.jpg" /> */}
      {/* <img src="https://cdn-cms.pgimgs.com/static/2019/05/backyard-garden-main-image.jpg " /> */}
      <img src="https://images.pexels.com/photos/4503732/pexels-photo-4503732.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" />

      <div className="Slogan">
        <h1> Plant trees for better tomorrow</h1>
      </div>
    </div>

    <div className="Banner2">

      <div class="card1" >
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPMNBn6WZ3l6ULovR2LsAgD6yDbdbyC340Vg&usqp=CAU" class="card-img-top1" alt="..." />
        <div class="card-body1">
          <h5 class="card-title1">Plants</h5>
          <p class="card-text1">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          <a href="#" class="btn btn-primary">Buy Plants</a>
        </div>
      </div>

      <div class="card1" >
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQeS5P4ADKKVoFTmJbmr94YYChqJGyFKfuF1g&usqp=CAU" class="card-img-top1" alt="..." />
        <div class="card-body1">
          <h5 class="card-title1">Planters</h5>
          <p class="card-text1">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          <a href="#" class="btn btn-primary">Buy Planters</a>
        </div>
      </div>

      <div class="card1" >
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTn0rMyuOaYzhgZE1X3NtQEB81AWt2-DI7r_g&usqp=CAU" class="card-img-top1" alt="..." />
        <div class="card-body1">
          <h5 class="card-title1">Seeds</h5>
          <p class="card-text1">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          <a href="#" class="btn btn-primary">Buy Seeds</a>
        </div>
      </div>

    </div>


    <div className="Banner3">
      <h1>Why should you buy from us?</h1>
      <div class="b3card1" >
        <img src="https://media.ugaoo.com/wysiwyg/usp1.png" class="card-img-top1" alt="..." />
        <div class="b3card-body1">
          <h5>Secure and recyclable</h5>
          <p class="card-text">Packaging that's a delight to receive and unpack</p>
        </div>
      </div>

      <div class="b3card1" >
        <img src="https://media.ugaoo.com/wysiwyg/usp2.png" class="card-img-top1" alt="..." />
        <div class="b3card-body1">
          <h5>Self-watering planters</h5>
          <p class="card-text">Convenient and easy to maintain</p>
        </div>
      </div>

      <div class="b3card1" >
        <img src="https://media.ugaoo.com/wysiwyg/usp3.png" class="card-img-top1" alt="..." />
        <div class="b3card-body1">
          <h5>Fulfiling plant journeys</h5>
          <p class="card-text">Plants Expert guidence and tips</p>
        </div>
      </div>

      <div class="b3card1" >
        <img src="https://media.ugaoo.com/wysiwyg/usp4.png" class="card-img-top1" alt="..." />
        <div class="b3card-body1">
          <h5>Easy returns and replacements</h5>
          <p class="card-text">That help you keep growing</p>
        </div>
      </div>

    </div>
  </div>
}