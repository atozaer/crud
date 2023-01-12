class Pagination {
    _obj; _current; _pageSize; _totalCount;
    _lastPage; _pageLimit; _block; _start; _end;
    _url; _searchParams;
    constructor(obj, current = 1,
                pageSize = 10,
                totalCount = 0,
                pageLimit = 10,
                url = window.location.pathname,
                searchParams = {}
    )
    {
        this._obj = obj;
        this._current = current;
        this._pageSize = pageSize;
        this._totalCount = totalCount;
        this._pageLimit = pageLimit;
        this._url = url;
        this._searchParams = searchParams;
        console.log(this._totalCount, this._pageSize);
        this._lastPage = Math.ceil(this._totalCount / this._pageSize);
        this._block = Math.ceil(this._current / this._pageLimit);
        this._start = ((this._block - 1) * this._pageLimit) + 1;
        this._end = Math.min(this._lastPage, (this._start + this._pageLimit) - 1);

        this.setPagination();
    }

    setPageLink = (pageNumber) => {
        this._searchParams['page'] = pageNumber;
        return `${this._url}?${Object.entries(this._searchParams).map(e => e.join("=")).join('&')}`;
    }

    setPagination() {
        let paginationList = [];

        if (this._start > 1) {
            paginationList.push(
                `<li class="page-arrow" onclick="location.href='${this.setPageLink(1)}'"><img height="11px" src="/img/common/svgs/solid/angles-left.svg"></li>`
            );
        }
        if (1 < this._current) {
            paginationList.push(
                `<li class="page-arrow" onclick="location.href='${this.setPageLink(this._current - 1)}'"><img height="11px" src="/img/common/svgs/solid/angle-left.svg"></li>`
            );
        }

        for (let i = this._start; i <= this._end; i++) {
            let currentPageClass = "";
            if (this._current == i) currentPageClass = "current-page";
            paginationList.push(
                `<li class="page-number ${currentPageClass}" onclick="location.href='${this.setPageLink(i)}'">${i}</li>`
            );
        }

        if (this._current < this._lastPage) {
            paginationList.push(
                `<li class="page-arrow" onclick="location.href='${this.setPageLink(this._current + 1)}'"><img height="11px" src="/img/common/svgs/solid/angle-right.svg"></li>`
            );
        }

        if (this._end < this._lastPage) {
            paginationList.push(
                `<li class="page-arrow" onclick="location.href='${this.setPageLink(this._lastPage)}'"><img height="11px" src="/img/common/svgs/solid/angles-right.svg"></li>`
            );
        }
        this._obj.innerHTML = `<ul class="page-list-group"></ul>`;
        let pagination = this._obj.querySelector('ul');
        pagination.classList.add("page-list-group");
        pagination.innerHTML = paginationList.join("");
    }
}
