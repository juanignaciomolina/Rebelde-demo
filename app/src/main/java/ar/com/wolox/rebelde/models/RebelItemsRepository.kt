package ar.com.wolox.rebelde.models

/**
 * MIT License
 *
 * Copyright (c) 2017 Wolox S.A
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 */
class RebelItemsRepository {

    fun provideAllItems(): List<IRebelItem> {
        return provideMotorcycles().plus(provideHaircuts()).plus(provideLeatherjackets())
    }

    fun provideMotorcycles(): List<Motorcycle> {
        return arrayListOf(
                Motorcycle("Ducati Cafe Racer", "A hipster motorcycle", 40000F, "http://www.cycleworld.com/sites/cycleworld.com/files/styles/large_1x_/public/images/2016/11/cw1116-2017-ducati-scrambler-cafe-racer-image-18.jpg?itok=YPi0-adE)"),
                Motorcycle("Ducati Scrambler", "A rough motorcycle", 30000F, "http://cdn3.drivek.it/bikes/models/scrambler-sixty-2.jpg"),
                Motorcycle("Ducati Monster", "A classic motorcycle", 40000F, "https://auto.ndtvimg.com/bike-images/big/ducati/monster-821/ducati-monster-821.jpg?v=4"),
                Motorcycle("Ducati Panigale R", "A monstrously fast motorcycle", 60000F, "https://motorfans.nl/wp-content/uploads/2016/02/01-PANIGALE-R-e1455028757383.jpg")
        )
    }

    fun provideLeatherjackets(): List<LeatherJacket> {
        return arrayListOf(
                LeatherJacket("Rockstar Jacket", "The jacket of a Rockstar", 1000F, "http://demandware.edgesuite.net/sits_pod26/dw/image/v2/AAPK_PRD/on/demandware.static/-/Sites-diesel-master-catalog/default/dw6c371f73/images/large/00SVCJ_0PANP_900_F.jpg?sw=320&sh=427"),
                LeatherJacket("College Jacket", "The jacket of a college student", 500F, "https://www.fjackets.com/product_images/uploaded_images/leather-jacket-men.jpg"),
                LeatherJacket("Biker Jacket", "A jacket ready to ride", 2000F, "http://images.asos-media.com/products/pepe-paul-slim-leather-biker-jacket/6851170-1-black"),
                LeatherJacket("Girl Power Jacket", "A jacket to conquer the world", 1500F, "http://images.urbanoutfitters.com/is/image/UrbanOutfitters/32618449_001_f")
        )
    }

    fun provideHaircuts(): List<Haircut> {
        return arrayListOf(
                Haircut("Rebel gentleman haircut", "The haircut of a gentleman", 100F, "https://s-media-cache-ak0.pinimg.com/236x/26/45/43/264543b166db5e5f09b2659a5d4ba7df--this-man-love-this.jpg"),
                Haircut("Long rebel haircut", "A long lasting haircut", 80F, "https://s-media-cache-ak0.pinimg.com/736x/b5/73/37/b57337d0bc7ecf593108827c544321a7--hairstyles-men-mens-hairstyle.jpg"),
                Haircut("Rebel star haircut", "Combine fame and revolution", 500F, "https://s-media-cache-ak0.pinimg.com/736x/2c/e5/cb/2ce5cb1da307d44c04d27f4b57c83336--hairstyle-for-man-hairstyle-ideas.jpg"),
                Haircut("Girly rebel haircut", "Cool cut for powerful girls", 200F, "https://s-media-cache-ak0.pinimg.com/236x/56/38/18/563818f2c753386e092f375576486c88--shaved-heads-shaved-head-women.jpg")
        )
    }
}